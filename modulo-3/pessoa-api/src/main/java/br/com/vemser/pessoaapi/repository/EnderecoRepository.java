package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 1, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil", "72140564", TipoEndereco.ofTipo(1), 1));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 2, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil", "72140564", TipoEndereco.ofTipo(2), 756));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 3, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil", "72140564", TipoEndereco.ofTipo(2), 496));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 4, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil", "72140564", TipoEndereco.ofTipo(1), 444));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 5, "Samambaia Norte", "QS 404", "Taguatinga", "Brasilia", "Brasil", "72140564", TipoEndereco.ofTipo(2), 333));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }

    public Endereco update(Endereco enderecoAntigo, Endereco enderecoNovo){
        enderecoNovo.setTipoEndereco(enderecoAntigo.getTipoEndereco());
        enderecoNovo.setIdEndereco(enderecoAntigo.getIdEndereco());
        enderecoNovo.setIdPessoa(enderecoAntigo.getIdPessoa());
        enderecoNovo.setCidade(enderecoAntigo.getCidade());
        enderecoNovo.setComplemento(enderecoAntigo.getComplemento());
        enderecoNovo.setEstado(enderecoAntigo.getEstado());
        enderecoNovo.setLogradouro(enderecoAntigo.getLogradouro());
        enderecoNovo.setCep(enderecoAntigo.getCep());
        return enderecoNovo;
    }

    public void delete(Endereco endereco){
        listaEndereco.remove(endereco);
    }

    public static List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public static void setListaEndereco(List<Endereco> listaEndereco) {
        EnderecoRepository.listaEndereco = listaEndereco;
    }



}
