package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public Pessoa adicionar(PessoaDTO pessoa){
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        return pessoaRepository.create(pessoaEntity);
    }

    public Pessoa editar(int id, PessoaDTO pessoa) throws Exception {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaRecuperada = this.verificaPessoa(id);
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());
        return pessoaRepository.update(pessoaRecuperada);
    }

    public void deletar(int id) throws Exception {
        Pessoa pessoaRecuperada = this.verificaPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public Pessoa verificaPessoa(int id) throws RegraDeNegocioException {
        return PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
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
