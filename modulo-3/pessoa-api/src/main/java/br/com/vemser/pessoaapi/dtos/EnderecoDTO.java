package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoEndereco;
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
public class EnderecoDTO {

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

    @Override
    public String toString() {
        return " logradouro: " + logradouro +
                "\n complemento: " + complemento +
                "\n cidade: " + cidade +
                "\n estado: " + estado +
                "\n pais: " + pais +
                "\n cep: " + cep +
                "\n tipoEndereco: " + tipoEndereco +
                "\n numero: " + numero;
    }
}
