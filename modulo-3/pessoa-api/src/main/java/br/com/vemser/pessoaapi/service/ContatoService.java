package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato adicionar(Contato Contato){
        return contatoRepository.createContato(Contato);
    }

    public Contato editar(int id, Contato Contato) throws Exception {
        return contatoRepository.updateContato(id, Contato);
    }

    public void deletar(int id) throws Exception {
        contatoRepository.deleteContato(id);
    }

    public List<Contato> listar(){
        return contatoRepository.list();
    }

    public List<Contato> listarPorNome(int id){
        return contatoRepository.listContatoByName(id);
    }

}
