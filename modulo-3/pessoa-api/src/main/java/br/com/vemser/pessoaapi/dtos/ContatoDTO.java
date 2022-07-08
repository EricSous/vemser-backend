package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoContato;
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
public class ContatoDTO {

    private Integer idContato;

    private Integer idPessoa;

    @NotEmpty
    @Size(max = 13)
    private String numero;

    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    private TipoContato tipoDeContato;

}
