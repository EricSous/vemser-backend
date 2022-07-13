package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
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

    public ContatoDTO adicionar(Integer id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        contatoEntidade.setIdPessoa(id);
        pessoaService.pessoaPorId(id);
        contatoRepository.createContato(contatoEntidade);
        return objectMapper.convertValue(contatoEntidade, ContatoDTO.class);
    }

    public ContatoDTO editar(int id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        System.out.println();
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        Contato contatoRecuperado = this.verificaPessoa(id);
        return objectMapper.convertValue(contatoRepository.updateContato(contatoRecuperado, contatoEntidade), ContatoDTO.class);
    }

    public void deletar(int id) throws RegraDeNegocioException {
        Contato pessoaRecuperada = this.verificaPessoa(id);
        contatoRepository.deleteContato(pessoaRecuperada);
    }

    public Contato verificaPessoa(int id) throws RegraDeNegocioException {
        return ContatoRepository.getListaContatos().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    public List<ContatoDTO> listar() {
        List<Contato> listaDto = contatoRepository.list();
        return listaDto.stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listarPorId(int id) {
        return this.listar().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}
