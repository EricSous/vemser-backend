package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.Professor;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/listar")
    public List<Professor> lista() {
        return professorRepository.findAll();
    }

    @PostMapping("/save")
    public Professor salva(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
}
