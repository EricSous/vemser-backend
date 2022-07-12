package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "Adiciona contato", description = "Adiciona contato ligando a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Adiciona contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public ContatoDTO create(@PathVariable("idPessoa") Integer id, @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.adicionar(id, contato);
    }

    @Operation(summary = "Lista contatos pelo id", description = "Traz a lista de contatos pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/contato
    public List<ContatoDTO> list() {
        return contatoService.listar();
    }

    @Operation(summary = "Lista contatos por pessoa", description = "Traz a lista de contatos pelo id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byIdPessoa") // localhost:8080/contato/byIdPessoa
    public List<ContatoDTO> listContatoById(@RequestParam("id") int id) {
        return contatoService.listarPorId(id);
    }

    @Operation(summary = "Altera contatos", description = "Altera contatos ligando a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista contato atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                         @RequestBody ContatoCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return contatoService.editar(id, pessoaAtualizar);
    }

    @Operation(summary = "Deleta contato", description = "Deleta contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato deletada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.deletar(id);
    }
}
