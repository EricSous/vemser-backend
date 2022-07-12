package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO adicionar(PessoaCreateDTO pessoa) {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        emailService.enviarEmailCrud(pessoaDTO, "email-template.ftl");
        return pessoaDTO;
    }

    public PessoaDTO editar(int id, PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaRecuperada = this.pessoaPorId(id);
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());
        PessoaDTO pessoaDto = objectMapper.convertValue(pessoaRepository.update(pessoaRecuperada), PessoaDTO.class);

        emailService.enviarEmailCrud(pessoaDto, "email-template2.ftl");
        return pessoaDto;
    }

    public void deletar(int id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = this.pessoaPorId(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.delete(pessoaRecuperada), PessoaDTO.class);
        emailService.enviarEmailCrud(pessoaDTO, "email-template3.ftl");
    }


    public List<PessoaDTO> listar() {
        List<Pessoa> listaDto = pessoaRepository.list();
        return listaDto.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listarPorNome(String nome) {
        List<PessoaDTO> listaDto = new ArrayList<>();
        return listaDto.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public Pessoa pessoaPorId(int id) throws RegraDeNegocioException {
        return PessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

}
