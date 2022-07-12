package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ContatoDTO adicionar(Integer id, ContatoDTO contato) throws RegraDeNegocioException {
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        contatoEntidade.setIdPessoa(id);
        pessoaService.verificarPessoa(id);
        contatoRepository.createContato(contatoEntidade);
        return objectMapper.convertValue(contatoEntidade, ContatoDTO.class);
    }

    public ContatoDTO editar(int id, ContatoDTO contato) throws Exception {
        System.out.println();
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        Contato contatoRecuperado = this.verificaPessoa(id);
        return objectMapper.convertValue(contatoRepository.updateContato(contatoRecuperado, contatoEntidade), ContatoDTO.class);
    }

    public void deletar(int id) throws Exception {
        Contato pessoaRecuperada = this.verificaPessoa(id);
        contatoRepository.deleteContato(pessoaRecuperada);
    }

    public Contato verificaPessoa(int id) throws Exception {
        return ContatoRepository.getListaContatos().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrado"));
    }

    public List<ContatoDTO> listar() {
        List<ContatoDTO> listaDto = new ArrayList<>();
        for (Contato contato : contatoRepository.list()) {
            listaDto.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        return listaDto;
    }

    public List<ContatoDTO> listarPorId(int id) {
        return this.listar().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}
