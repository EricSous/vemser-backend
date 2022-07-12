package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @Schema(description = "Tipo de contado 1- RESIDENCIAL 2- Comercial")
    @NotNull
    private TipoContato tipo;

    @Schema(description = "Numero para contato")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size
    private String numero;

    @Schema(description = "Informações do contato")
    @NotEmpty
    @NotNull
    private String descricao;

}
