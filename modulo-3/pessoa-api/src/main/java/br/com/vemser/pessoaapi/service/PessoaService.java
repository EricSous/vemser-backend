package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public PessoaDTO adicionar(PessoaDTO pessoa){
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaRepository.create(pessoaEntity);
        return pessoa;
    }

    public PessoaDTO editar(int id, PessoaDTO pessoa) throws Exception {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaRecuperada = this.verificarPessoa(id);
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaRepository.update(pessoaRecuperada);
        return pessoa;
    }

    public void deletar(int id) throws Exception {
        Pessoa pessoaRecuperada = this.verificarPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public Pessoa verificarPessoa(int id) throws RegraDeNegocioException {
        return PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não ENCONTRADO/ENCONTRADA"));
    }

    public List<PessoaDTO> listar(){
        List<PessoaDTO> listaDto = new ArrayList<>();
        for (Pessoa pessoa : pessoaRepository.list()) {
            listaDto.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return listaDto;
    }

    public List<PessoaDTO> listarPorNome(String nome){
        List<PessoaDTO> listaDto = new ArrayList<>();
        for (Pessoa pessoa :         pessoaRepository.listByName(nome)) {
            listaDto.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return listaDto;
    }

    public Pessoa pessoaPorNome(String nome){
        return pessoaRepository.peopleByName(nome);
    }

    public Pessoa pessoaPorId(int id){
        return pessoaRepository.peopleById(id);
    }

}
