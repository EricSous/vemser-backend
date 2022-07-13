package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dtos.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.DadosPessoaisClientService;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosContato")
public class DadosPessoaisClientController {

    @Autowired
    private DadosPessoaisClientService dadosPessoaisClientService;

    @Operation(summary = "Lista todos Dados", description = "Traz a lista de todos os dados de clientes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<DadosPessoaisDTO> retornaEndereco() {
        return dadosPessoaisClientService.listaTodos();
    }

    @Operation(summary = "adiciona Cliente", description = "Adiciona um novo cliente na API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Adiciona dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/adicionar")
    public DadosPessoaisDTO adicionar(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClientService.adicionaClient(dadosPessoaisDTO);
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza um novo cliente na API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/atualizar")
    public DadosPessoaisDTO atualizar(@RequestParam String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClientService.alteraClient(cpf, dadosPessoaisDTO);
    }

    @Operation(summary = "Deleta cliente", description = "Deleta o cliente da API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/deletar")
    public void delete(@RequestParam String cpf) {
        dadosPessoaisClientService.deletaCliente(cpf);
    }

    @Operation(summary = "Lista dado por cpf", description = "Lista dado por cpf")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista por cpf"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/porCPF")
    public DadosPessoaisDTO retornaEndereco(@RequestParam String cpf) {
        return dadosPessoaisClientService.buscaPorCPF(cpf);
    }


}
