package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 1, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 2, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 3, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 4, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 5, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil"));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }

    public Endereco update(Endereco endereco) throws Exception {
        return endereco;
    }

    public void delete(Endereco endereco) throws Exception {
        listaEndereco.remove(endereco);
    }

    public static List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public static void setListaEndereco(List<Endereco> listaEndereco) {
        EnderecoRepository.listaEndereco = listaEndereco;
    }



}
