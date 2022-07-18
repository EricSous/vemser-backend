package br.com.vemser.pessoaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosPessoaisComPessoaService {

    @Autowired
    private DadosPessoaisClientService dadosPessoaisClientService;

    @Autowired
    private PessoaService pessoaService;

    public boolean verificaPessoasIguais(String cpf){
        return pessoaService.listar().stream().anyMatch(p -> p.getCpf().equals(dadosPessoaisClientService.buscaPorCPF(p.getCpf()).getCpf()));
    }


}
