package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.entities.EnderecoPessoaEntity;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoPessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public EnderecoDTO adicionar(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.pessoaPorId(id);

        EnderecoPessoaEntity enderecoEntidade = objectMapper.convertValue(endereco, EnderecoPessoaEntity.class);
        enderecoEntidade.setPessoa(Set.of(pessoa));

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoPessoaRepository.save(enderecoEntidade), EnderecoDTO.class);
        enderecoDTO.setId(id);

        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
        return enderecoDTO;
    }

    public EnderecoDTO editar(int id, EnderecoCreateDTO enderecoNovo) {
        EnderecoPessoaEntity enderecoEntidade = objectMapper.convertValue(enderecoNovo, EnderecoPessoaEntity.class);
        enderecoEntidade.setId(id);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoPessoaRepository.save(enderecoEntidade), EnderecoDTO.class);
        enderecoDTO.setId(id);

        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
        return enderecoDTO;
    }

    public void deletar(int id) {
        EnderecoPessoaEntity enderecoRecuperado = this.verificaEndereco(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);

        enderecoPessoaRepository.delete(enderecoRecuperado);
        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
    }

    public EnderecoPessoaEntity verificaEndereco(int id){
        return enderecoPessoaRepository.findById(id).get();
    }

    public List<EnderecoDTO> listar() {
        return enderecoPessoaRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listarPorIdEndereco(int id) {
        return objectMapper.convertValue(enderecoPessoaRepository.findById(id).get(), EnderecoDTO.class);

    }

    public List<EnderecoDTO> listPorPessoa(Integer id) {
        return this.listar().stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
