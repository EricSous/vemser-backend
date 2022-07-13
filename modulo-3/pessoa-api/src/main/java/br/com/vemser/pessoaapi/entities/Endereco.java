package br.com.vemser.pessoaapi.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    private Integer idEndereco;

    private Integer idPessoa;

    private String logradouro;

    private String complemento;

    private String cidade;

    private String estado;

    private String pais;

    private String cep;

    private TipoEndereco tipoEndereco;

    private Integer numero;

}
