package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.dtos.PessoaDTO;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public EnderecoDTO adicionar(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        endereco.setIdPessoa(id);
        Endereco enderecoEntidade = objectMapper.convertValue(endereco, Endereco.class);
        pessoaService.pessoaPorId(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.create(enderecoEntidade), EnderecoDTO.class);
        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
        return enderecoDTO;
    }

    public EnderecoDTO editar(int id, EnderecoCreateDTO enderecoNovo) throws RegraDeNegocioException {
        Endereco enderecoEntidade = objectMapper.convertValue(enderecoNovo, Endereco.class);
        Endereco enderecoAntigo = this.verificaEndereco(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.update(enderecoAntigo, enderecoEntidade), EnderecoDTO.class);
        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
        return enderecoDTO;
    }

    public void deletar(int id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = this.verificaEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        emailService.enviarEmailCrudEndereco(enderecoDTO, "email-endereco-template.ftl");
    }

    public Endereco verificaEndereco(int id) throws RegraDeNegocioException {
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }

    public List<EnderecoDTO> listar() {
        List<Endereco> listaEndereco = enderecoRepository.list();
        return listaEndereco.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listarPorEndereco(int id) {
        List<Endereco> listaEndereco = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .collect(Collectors.toList());
        return listaEndereco.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listPorPessoa(Integer id) {
        List<Endereco> listaEndereco = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .collect(Collectors.toList());
        return listaEndereco.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
}
