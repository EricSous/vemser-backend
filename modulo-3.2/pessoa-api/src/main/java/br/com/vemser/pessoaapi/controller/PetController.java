package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.PetCreateDTO;
import br.com.vemser.pessoaapi.dtos.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/listar")
    public List<PetDTO> listar() {
        return petService.listar();
    }

    @PostMapping("/adicionar")
    public PetDTO adicionar(@RequestParam int id,@RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return petService.adicionarPet(id, petCreateDTO);
    }

    @PutMapping("/editar")
    public PetDTO editar(@RequestBody PetDTO petDTO) throws RegraDeNegocioException {
        return petService.editarPet(petDTO);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestParam int id) throws RegraDeNegocioException {
        petService.deletar(id);
    }

}
