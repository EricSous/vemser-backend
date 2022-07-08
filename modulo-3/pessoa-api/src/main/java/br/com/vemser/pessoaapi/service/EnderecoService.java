package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public Endereco adicionar(Integer id, EnderecoDTO endereco) throws RegraDeNegocioException {
        endereco.setIdPessoa(id);
        Endereco enderecoEntidade = objectMapper.convertValue(endereco, Endereco.class);
        PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return enderecoRepository.create(enderecoEntidade);
    }

    public Endereco editar(int id, EnderecoDTO enderecoNovo) throws Exception {
        Endereco enderecoEntidade = objectMapper.convertValue(enderecoNovo, Endereco.class);
        Endereco enderecoAntigo = this.verificaEndereco(id);
        return enderecoRepository.update(enderecoAntigo,enderecoEntidade);
    }

    public void deletar(int id) throws Exception {
        Endereco enderecoRecuperado = this.verificaEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public Endereco verificaEndereco(int id) throws RegraDeNegocioException {
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não econtrada"));
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
