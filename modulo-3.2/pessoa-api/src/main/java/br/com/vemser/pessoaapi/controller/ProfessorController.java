package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.ProfessorEntity;
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
    public List<ProfessorEntity> lista() {
        return professorRepository.findAll();
    }

    @PostMapping("/save")
    public ProfessorEntity salva(@RequestBody ProfessorEntity professor) {
        return professorRepository.save(professor);
    }
}
