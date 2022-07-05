package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        PessoaService pessoaService = new PessoaService();
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, "61994514396", "Movel"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, "61994513396", "Movel"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, "61999999999", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, "61394514396", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, "61794514396", "Residencial"));
    }

    public Contato createContato(Contato pessoa) {
        pessoa.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(pessoa);
        return pessoa;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato updateContato(Integer id,
                         Contato pessoaAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        contatoRecuperado.setDescricao(pessoaAtualizar.getDescricao());
        contatoRecuperado.setNumero(pessoaAtualizar.getNumero());
        contatoRecuperado.setDescricao(pessoaAtualizar.getDescricao());
        contatoRecuperado.setIdPessoa(pessoaAtualizar.getIdPessoa());
        return contatoRecuperado;
    }

    public void deleteContato(Integer id) throws Exception {
        Contato pessoaRecuperada = listaContatos.stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        listaContatos.remove(pessoaRecuperada);
    }

    public List<Contato> listContatoByName(int id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
