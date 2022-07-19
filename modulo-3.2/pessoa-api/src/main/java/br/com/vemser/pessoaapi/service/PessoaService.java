package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        emailService.enviarEmailCrud(pessoaDTO, "email-template.ftl");
        return pessoaDTO;
    }

    public PessoaDTO editar(int id, PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaPorId(id);

        pessoaEntity.setId(id);
        PessoaDTO pessoaDto = objectMapper.convertValue(pessoaRepository.save(pessoaEntity), PessoaDTO.class);

        emailService.enviarEmailCrud(pessoaDto, "email-template2.ftl");
        return pessoaDto;
    }

    public void deletar(int id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = this.pessoaPorId(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
        pessoaRepository.delete(pessoaRecuperada);
        emailService.enviarEmailCrud(pessoaDTO, "email-template3.ftl");
    }


    public List<PessoaDTO> listar() {
        return pessoaRepository.findAll().stream()
                .map(p -> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listarPorNome(String nome) {
        return this.listar().stream()
                .filter(p -> p.getNome().equals(nome))
                .collect(Collectors.toList());
    }

    public Pessoa pessoaPorId(int id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

}
