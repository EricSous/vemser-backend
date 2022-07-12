package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Lista todos endereços", description = "Traz a lista de endereços")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<EnderecoDTO> retornaEndereco(){
        return enderecoService.listar();
    }

    @Operation(summary = "Lista endereços pelo id", description = "Traz a lista de endereços pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> retornaEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco){
        return enderecoService.listarPorEndereco(idEndereco);
    }

    @Operation(summary = "Lista endereços por pessoa", description = "Traz a lista de endereços pelo id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> retornaEnderecoPorPessoa(@PathVariable("idPessoa") Integer idPessoa){
        return enderecoService.listPorPessoa(idPessoa);
    }

    @Operation(summary = "Adiciona endereços", description = "Adiciona endereços ligando a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereço adicionado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public EnderecoDTO adicionarEndereco(@PathVariable("idPessoa") Integer idPessoa, @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return enderecoService.adicionar(idPessoa,endereco);
    }

    @Operation(summary = "Altera endereços", description = "Altera endereços ligando a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereço atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public EnderecoDTO editaEndereco(@PathVariable("idEndereco") Integer idEndereco, @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return enderecoService.editar(idEndereco,endereco);
    }

    @Operation(summary = "Deleta endereço", description = "Deleta endereços")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deletada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void deletaEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.deletar(idEndereco);
    }
}
