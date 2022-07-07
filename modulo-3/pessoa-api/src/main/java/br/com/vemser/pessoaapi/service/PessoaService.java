package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa adicionar(Pessoa pessoa){
        Boolean verificaNome = StringUtils.isBlank(pessoa.getNome());
        Boolean verificaDataNascimento = StringUtils.isEmpty(pessoa.getCpf());
        Boolean verificaCPF = StringUtils.isBlank(pessoa.getCpf());
        Boolean verificaTamanhos = pessoa.getCpf().length() == 11;
        if(verificaNome && verificaDataNascimento && verificaCPF && verificaTamanhos){
            System.out.println("Nao e possivel adicionar está pessoa");
        }else {
            return pessoaRepository.create(pessoa);
        }
        return null;
    }

    public Pessoa editar(int id, Pessoa pessoa) throws Exception {
        Pessoa pessoaRecuperada = PessoaRepository.getListaPessoas().stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoa.getCpf());
        pessoaRecuperada.setNome(pessoa.getNome());
        pessoaRecuperada.setDataNascimento(pessoa.getDataNascimento());
        return pessoaRepository.update(pessoaRecuperada);
    }

    public void deletar(int id) throws Exception {
        Pessoa pessoaRecuperada = PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listar(){
        return pessoaRepository.list();
    }

    public List<Pessoa> listarPorNome(String nome){
        return pessoaRepository.listByName(nome);
    }

    public Pessoa pessoaPorNome(String nome){
        return pessoaRepository.peopleByName(nome);
    }

    public Pessoa pessoaPorId(int id){
        return pessoaRepository.peopleById(id);
    }

}
