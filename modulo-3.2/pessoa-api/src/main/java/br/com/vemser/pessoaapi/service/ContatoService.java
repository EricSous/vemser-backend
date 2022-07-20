package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.entities.ContatoEntity;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO adicionar(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException {
        ContatoEntity contatoEntidade = objectMapper.convertValue(contato, ContatoEntity.class);
        PessoaEntity pessoa =pessoaService.pessoaPorId(idPessoa);

        contatoEntidade.setIdPessoa(idPessoa);
        contatoEntidade.setPessoa(pessoa);

        ContatoEntity contatoSalvo = contatoRepository.save(contatoEntidade);
        contatoEntidade.setId(contatoSalvo.getId());

        return objectMapper.convertValue(contatoEntidade, ContatoDTO.class);
    }

    public ContatoDTO editar(int id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        ContatoEntity contatoExist = this.verificaContato(id);
        ContatoEntity contatoEntidade = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntidade.setId(id);
        contatoEntidade.setPessoa(contatoExist.getPessoa());
        return objectMapper.convertValue(contatoRepository.save(contatoEntidade), ContatoDTO.class);
    }

    public void deletar(int id) throws RegraDeNegocioException {
        ContatoEntity pessoaRecuperada = this.verificaContato(id);
        contatoRepository.delete(pessoaRecuperada);
    }

    public ContatoEntity verificaContato(int id) throws RegraDeNegocioException {
        return contatoRepository.findById(id).stream().findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    public List<ContatoDTO> listar() {
        List<ContatoEntity> listaDto = contatoRepository.findAll();
        return listaDto.stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO listarPorId(int id) throws RegraDeNegocioException {
        return objectMapper.convertValue(this.verificaContato(id), ContatoDTO.class);
    }

}
