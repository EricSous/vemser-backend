package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PetCreateDTO;
import br.com.vemser.pessoaapi.dtos.PetDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.entities.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PessoaService pessoaService;

    public PetDTO adicionarPet(int id, PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity pet = objectMapper.convertValue(petCreateDTO, PetEntity.class);
        PessoaEntity pessoaDoPet = pessoaService.pessoaPorId(id);

        pet.setPessoa(pessoaDoPet);
        petRepository.save(pet);
        pessoaDoPet.setPet(pet);

        pessoaService.save(pessoaDoPet);

        return objectMapper.convertValue(pet, PetDTO.class);
    }

    public PetDTO editarPet(PetDTO petDTO) throws RegraDeNegocioException {
        PetEntity petParaEditar = verificaPet(petDTO.getId());

        PetEntity pet = objectMapper.convertValue(petDTO, PetEntity.class);
        pet.setPessoa(petParaEditar.getPessoa());
        PessoaEntity pessoaParaEditar = pessoaService.pessoaPorId(petParaEditar.getPessoa().getId());

        petRepository.save(pet);
        pessoaService.save(pessoaParaEditar);

        return petDTO;
    }

    public List<PetDTO> listar(){
        return petRepository.findAll().stream()
                .map(a -> objectMapper.convertValue(a,PetDTO.class))
                .toList();
    }

    public void deletar(int id) throws RegraDeNegocioException {

        petRepository.delete(objectMapper.convertValue(verificaPet(id), PetEntity.class));
    }

    public PetEntity verificaPet(int id) throws RegraDeNegocioException {
        return petRepository
                .findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}
