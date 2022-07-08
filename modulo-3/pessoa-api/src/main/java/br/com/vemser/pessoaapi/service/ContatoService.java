package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public Contato adicionar(Integer id, ContatoDTO contato) throws RegraDeNegocioException {
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        contatoEntidade.setIdPessoa(id);
        PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return contatoRepository.createContato(contatoEntidade);
    }

    public Contato editar(int id, ContatoDTO contato) throws Exception {
        System.out.println();
        Contato contatoEntidade = objectMapper.convertValue(contato, Contato.class);
        Contato contatoRecuperado = this.verificaPessoa(id);
        return contatoRepository.updateContato(contatoRecuperado, contatoEntidade);
    }

    public void deletar(int id) throws Exception {
        Contato pessoaRecuperada = this.verificaPessoa(id);
        contatoRepository.deleteContato(pessoaRecuperada);
    }

    public Contato verificaPessoa(int id) throws Exception {
        return ContatoRepository.getListaContatos().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
    }

    public List<Contato> listar() {
        return contatoRepository.list();
    }

    public List<Contato> listarPorId(int id) {
        return ContatoRepository.getListaContatos().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}
