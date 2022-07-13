package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class ContatoDTO extends ContatoCreateDTO{

    @Schema(description = "Id do contato")
    private Integer idContato;

}
