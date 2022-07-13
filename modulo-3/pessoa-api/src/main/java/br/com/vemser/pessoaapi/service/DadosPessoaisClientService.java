package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dtos.DadosPessoaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisClientService {

    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> listaTodos() {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDTO adicionaClient(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO alteraClient(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public void deletaCliente(String cpf){
        dadosPessoaisClient.delete(cpf);
    }

    public DadosPessoaisDTO buscaPorCPF(String cpf){
        return dadosPessoaisClient.get(cpf);
    }


}
