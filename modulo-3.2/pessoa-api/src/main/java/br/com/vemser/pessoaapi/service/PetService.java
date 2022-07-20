package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.dtos.PetCreateDTO;
import br.com.vemser.pessoaapi.dtos.PetDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.entities.Pet;
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
        Pet pet = objectMapper.convertValue(petCreateDTO, Pet.class);
        Pessoa pessoaDoPet = pessoaService.pessoaPorId(id);
        pet.setPessoa(pessoaDoPet);
        petRepository.save(pet);
        return objectMapper.convertValue(pet, PetDTO.class);
    }

    public PetDTO editarPet(PetDTO petDTO) throws RegraDeNegocioException {
        Pet petParaEditar = verificaPet(petDTO.getId());

        Pet pet = objectMapper.convertValue(petDTO, Pet.class);
        pet.setPessoa(petParaEditar.getPessoa());
        petRepository.save(pet);

        return petDTO;
    }

    public List<PetDTO> listar(){
        return petRepository.findAll().stream().map(a -> objectMapper.convertValue(a,PetDTO.class)).toList();
    }

    public void deletar(int id) throws RegraDeNegocioException {

        petRepository.delete(objectMapper.convertValue(verificaPet(id),Pet.class));
    }

    public Pet verificaPet(int id) throws RegraDeNegocioException {
        return petRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}
