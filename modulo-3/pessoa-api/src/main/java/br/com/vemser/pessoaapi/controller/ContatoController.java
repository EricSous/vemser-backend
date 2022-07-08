package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public Contato create(@PathVariable("idPessoa") Integer id, @RequestBody ContatoDTO contato) throws RegraDeNegocioException {
        return contatoService.adicionar(id, contato);
    }

    @GetMapping // localhost:8080/contato
    public List<Contato> list() {
        return contatoService.listar();
    }

    @GetMapping("/byIdPessoa") // localhost:8080/contato/byIdPessoa
    public List<Contato> listContatoById(@RequestParam("id") int id) {
        return contatoService.listarPorId(id);
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody ContatoDTO pessoaAtualizar) throws Exception {
        return contatoService.editar(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.deletar(id);
    }
}
