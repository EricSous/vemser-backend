package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoService(){
        enderecoRepository = new EnderecoRepository();
    }

    public Endereco adicionar(Integer id, Endereco endereco) throws RegraDeNegocioException {
        endereco.setIdPessoa(id);
        PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return enderecoRepository.create(endereco);
    }

    public Endereco editar(int id, Endereco enderecoNovo) throws Exception {
        Endereco enderecoAntigo = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não econtrada"));
        return enderecoRepository.update(enderecoAntigo,enderecoNovo);
    }

    public void deletar(int id) throws Exception {
        Endereco enderecoRecuperado = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não econtrada"));
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listar(){
        return enderecoRepository.list();
    }

    public List<Endereco> listarPorEndereco(int id){
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listPorPessoa(Integer id) {
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
