package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/ambiente")
    public String retornaAmbiente(){
        return propertieReader.getUsuario();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.listar();
    }

    @Operation(summary = "listar pessoas pelo nome", description = "Lista todas as pessoas do banco com o nome especificado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna as pessoas com o nome"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listarPorNome(nome);
    }

    @Operation(summary = "criação de pessoa", description = "Cria uma nova pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    public PessoaDTO create(@Valid @RequestBody PessoaDTO pessoa){
        return pessoaService.adicionar(pessoa);
    }

    @Operation(summary = "atualiza uma pessoa", description = "atualiza uma nova pessoa pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaService.editar(id, pessoaAtualizar);
    }

    @Operation(summary = "deleta uma pessoa", description = "Deleta uma nova pessoa pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deletado a pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.deletar(id);
    }
}
