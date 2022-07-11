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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public EnderecoDTO adicionar(Integer id, EnderecoDTO endereco) throws RegraDeNegocioException {
        endereco.setIdPessoa(id);
        Endereco enderecoEntidade = objectMapper.convertValue(endereco, Endereco.class);
        pessoaService.verificarPessoa(id);
        enderecoRepository.create(enderecoEntidade);
        return endereco;
    }

    public EnderecoDTO editar(int id, EnderecoDTO enderecoNovo) throws Exception {
        Endereco enderecoEntidade = objectMapper.convertValue(enderecoNovo, Endereco.class);
        Endereco enderecoAntigo = this.verificaEndereco(id);
        enderecoRepository.update(enderecoAntigo,enderecoEntidade);

        return  enderecoNovo;
    }

    public void deletar(int id) throws Exception {
        Endereco enderecoRecuperado = this.verificaEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public Endereco verificaEndereco(int id) throws RegraDeNegocioException {
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não econtrado"));
    }

    public List<EnderecoDTO> listar(){

        List<EnderecoDTO> listaDto = new ArrayList<>();
        for (Endereco endereco : enderecoRepository.list()) {
            listaDto.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listaDto;
    }

    public List<EnderecoDTO> listarPorEndereco(int id){
        List<Endereco> listaEndereco = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .collect(Collectors.toList());
        List<EnderecoDTO> listaDto = new ArrayList<>();

            for (Endereco endereco : listaEndereco) {
                listaDto.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
            }

        return listaDto;
    }

    public List<EnderecoDTO> listPorPessoa(Integer id) {
        List<Endereco> listaEndereco = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .collect(Collectors.toList());
        List<EnderecoDTO> listaDto = new ArrayList<>();

        for (Endereco endereco : listaEndereco) {
            listaDto.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listaDto;
    }
}
