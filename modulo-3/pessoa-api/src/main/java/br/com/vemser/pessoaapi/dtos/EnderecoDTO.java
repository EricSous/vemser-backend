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
public class EnderecoDTO extends EnderecoCreateDTO{

    private Integer idEndereco;


}
