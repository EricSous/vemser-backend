package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoPet;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {

    private String nome;
    private TipoPet tipoPet;

}
