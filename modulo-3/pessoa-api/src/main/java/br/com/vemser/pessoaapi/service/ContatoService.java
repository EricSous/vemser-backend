package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato adicionar(Integer id, Contato contato){
        contato.setIdPessoa(id);
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
