package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.*;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
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
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        emailService.enviarEmailCrud(pessoaDTO, "email-template.ftl");
        return pessoaDTO;
    }

    public PessoaEntity save(PessoaEntity pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public PessoaDTO editar(int id, PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        PessoaEntity pessoa1 = pessoaPorId(id);
        pessoaEntity.setPet(pessoa1.getPet());
        pessoaEntity.setId(id);
        PessoaDTO pessoaDto = objectMapper.convertValue(pessoaRepository.save(pessoaEntity), PessoaDTO.class);

        emailService.enviarEmailCrud(pessoaDto, "email-template2.ftl");
        return pessoaDto;
    }

    public void deletar(int id) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = this.pessoaPorId(id);
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

    public PessoaEntity pessoaPorId(int id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaContatoDTO> pessoaContatoPorId(Integer id) {
        List<PessoaEntity> lista = id == null ? pessoaRepository.findAll() : List.of(pessoaRepository.findById(id).get());
        return lista.stream()
                .map(p -> {
                    PessoaContatoDTO pessoaDTO = objectMapper.convertValue(p, PessoaContatoDTO.class);
                    pessoaDTO.setContatoDTOS(p.getContatos().stream()
                            .map(e -> objectMapper.convertValue(e, ContatoDTO.class)).toList());
                    return pessoaDTO;
                }).toList();
    }

    public List<PessoaEnderecoDTO> pessoaEnderecoPorId(Integer id) {
        List<PessoaEntity> lista = id == null ? pessoaRepository.findAll() : List.of(pessoaRepository.findById(id).get());
        return lista.stream()
                .map(p -> {
                    PessoaEnderecoDTO pessoaDTO = objectMapper.convertValue(p, PessoaEnderecoDTO.class);
                    pessoaDTO.setEnderecoDTOS(p.getEnderecoPessoa().stream()
                            .map(e -> objectMapper.convertValue(e, EnderecoDTO.class)).toList());
                    return pessoaDTO;
                }).toList();
    }


    public List<PessoaPetDTO> pessoaPetPorId(Integer id) {
        List<PessoaEntity> lista = id == null ? pessoaRepository.findAll() : List.of(pessoaRepository.findById(id).get());
        return lista.stream()
                .map(p -> {
                    PessoaPetDTO petDTO = objectMapper.convertValue(p, PessoaPetDTO.class);
                    petDTO.setPetDTO(objectMapper.convertValue(p.getPet(), PetDTO.class));
                    return petDTO;
                }).toList();
    }

    public List<PessoaCompletaDTO> pessoaCompletaPorId(Integer id) {
        List<PessoaEntity> lista = id == null ? pessoaRepository.findAll() : List.of(pessoaRepository.findById(id).get());
        return lista.stream()
                .map(p -> {
                    PessoaCompletaDTO pessoaCompletaDTO = objectMapper.convertValue(p, PessoaCompletaDTO.class);
                    pessoaCompletaDTO.setPetDTOS(objectMapper.convertValue(p.getPet(), PetDTO.class));
                    pessoaCompletaDTO.setEnderecoDTOS(p.getEnderecoPessoa().stream()
                            .map(e -> objectMapper.convertValue(e, EnderecoDTO.class)).toList());
                    pessoaCompletaDTO.setContatoDTOS(p.getContatos().stream()
                            .map(e -> objectMapper.convertValue(e, ContatoDTO.class)).toList());
                    return pessoaCompletaDTO;
                }).toList();
    }

    public List<PessoaCompostaTudoDTO> pessoaCompostaTudoPorId() {
        return pessoaRepository.findPessoaCompostaTudo();
    }


}
