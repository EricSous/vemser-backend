package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private TipoContato tipo;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size
    private String numero;

    @NotEmpty
    @NotNull
    private String descricao;

}
