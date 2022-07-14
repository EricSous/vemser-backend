package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.service.DadosPessoaisComPessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dadosContatoPessoa")
public class DadosPessoaisComPessoasController {

    @Autowired
    DadosPessoaisComPessoaService dadosPessoaisComPessoaService;

    @Operation(summary = "Procura cpf", description = "Verifica se o cpf dos dados pessoais existe na pessoa api")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Busca cpf"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/buscaCPF")
    public boolean retornaEndereco(@RequestParam String cpf){
        return dadosPessoaisComPessoaService.verificaPessoasIguais(cpf);
    }
}
