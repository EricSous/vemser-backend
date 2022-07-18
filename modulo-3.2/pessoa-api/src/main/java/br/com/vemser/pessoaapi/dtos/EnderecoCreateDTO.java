package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    @Schema(description = "Tipo de endereço 1- Residencial 2- Comercial")
    @NotNull
    private TipoEndereco tipoEndereco;

    @Schema(description = "Logradouro de onde a pessoa mora")
    @NotNull
    @Size(max = 250)
    private String logradouro;

    @Schema(description = "Numero da casa")
    @NotNull
    private Integer numero;

    @Schema(description = "Complemento de onde a pessoa mora")
    private String complemento;

    @Schema(description = "CEP de onde a pessoa mora")
    @NotNull
    @NotEmpty
    @Size(max = 8)
    private String cep;

    @Schema(description = "Cidade de onde a pessoa mora")
    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @Schema(description = "Estado de onde a pessoa mora")
    @NotNull
    private String estado;

    @Schema(description = "Pais de onde a pessoa mora")
    @NotNull
    private String pais;

}
