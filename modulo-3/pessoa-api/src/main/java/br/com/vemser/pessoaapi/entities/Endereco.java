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

    @NotNull
    @Size(max = 250)
    private String logradouro;

    private String complemento;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;

    @NotNull
    @NotEmpty
    @Size(max = 8)
    private String cep;

    @NotNull
    private TipoEndereco tipoEndereco;

    @NotNull
    private Integer numero;

}
