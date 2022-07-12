package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO adicionar(PessoaDTO pessoa){
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity,PessoaDTO.class);
        emailService.enviarEmailCrud(pessoa,"email-template.ftl");
        return pessoaDTO;
    }

    public PessoaDTO editar(int id, PessoaDTO pessoa) throws Exception {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaRecuperada = this.verificarPessoa(id);
        pessoaRecuperada.setCpf(pessoaEntity.getCpf());
        pessoaRecuperada.setNome(pessoaEntity.getNome());
        pessoaRecuperada.setDataNascimento(pessoaEntity.getDataNascimento());
        PessoaDTO pessoaDto = objectMapper.convertValue(pessoaRepository.update(pessoaRecuperada),PessoaDTO.class);

        emailService.enviarEmailCrud(pessoa,"email-template2.ftl");
        return pessoaDto;
    }

    public void deletar(int id) throws Exception {
        Pessoa pessoaRecuperada = this.verificarPessoa(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.delete(pessoaRecuperada),PessoaDTO.class);
        emailService.enviarEmailCrud(pessoaDTO,"email-template3.ftl");
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
