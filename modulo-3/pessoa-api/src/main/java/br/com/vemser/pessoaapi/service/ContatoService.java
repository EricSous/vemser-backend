package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato adicionar(Integer id, Contato contato) throws RegraDeNegocioException {
        contato.setIdPessoa(id);
        Pessoa pessoaRecuperada = PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return contatoRepository.createContato(contato);
    }

    public Contato editar(int id, Contato contato) throws Exception {
        Contato contatoRecuperado = ContatoRepository.getListaContatos().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        return contatoRepository.updateContato(id, contatoRecuperado);
    }

    public void deletar(int id) throws Exception {
        Contato pessoaRecuperada = ContatoRepository.getListaContatos().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        contatoRepository.deleteContato(pessoaRecuperada);
    }

    public List<Contato> listar(){
        return contatoRepository.list();
    }

    public List<Contato> listarPorNome(int id){
        return ContatoRepository.getListaContatos().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}