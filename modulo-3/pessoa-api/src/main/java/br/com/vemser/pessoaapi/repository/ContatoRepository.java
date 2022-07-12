package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.entities.TipoContato;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public static List<Contato> getListaContatos() {
        return listaContatos;
    }

    public static void setListaContatos(List<Contato> listaContatos) {
        ContatoRepository.listaContatos = listaContatos;
    }

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, "61994514396", "MEU PRIVADO", TipoContato.ofTipo(1)));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, "61994513396", "MEU PRIVADO", TipoContato.ofTipo(2)));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, "61999999999", "CASA", TipoContato.ofTipo(1)));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, "61394514396", "CASA", TipoContato.ofTipo(1)));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, "61794514396", "CASA", TipoContato.ofTipo(2)));
    }

    public Contato createContato(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato updateContato(Contato contatoAntigo, Contato contatoNovo) {
        contatoAntigo.setDescricao(contatoNovo.getDescricao());
        contatoAntigo.setNumero(contatoNovo.getNumero());
        contatoAntigo.setDescricao(contatoNovo.getDescricao());
        contatoAntigo.setIdPessoa(contatoNovo.getIdPessoa());
        return contatoAntigo;
    }

    public void deleteContato(Contato contato) {
        listaContatos.remove(contato);
    }

}
