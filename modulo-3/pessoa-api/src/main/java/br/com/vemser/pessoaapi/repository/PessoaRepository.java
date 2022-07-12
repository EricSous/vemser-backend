package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Pessoa;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi",  formatter.parse("10/10/1990"), "12345678910","ericandradedesousa8@hotmail.com"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", formatter.parse("08/05/1985"), "12345678911","ericandradedesousa8@hotmail.com"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", formatter.parse("30/03/1970"), "12345678912","ericandradedesousa8@hotmail.com"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", formatter.parse("01/07/1990"), "12345678916","ericandradedesousa8@hotmail.com"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana", formatter.parse("01/07/1990"), "12345678917","ericandradedesousa8@hotmail.com"));
    }

    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa update(Pessoa pessoaAtualizada){
        listaPessoas.add(pessoaAtualizada);
        return pessoaAtualizada;
    }

    public Pessoa delete(Pessoa pessoaRecuperada){
        listaPessoas.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public static List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public static void setListaPessoas(List<Pessoa> listaPessoas) {
        PessoaRepository.listaPessoas = listaPessoas;
    }

    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
