package br.com.vemser.pessoaapi.dtos;

import br.com.vemser.pessoaapi.entities.TipoSexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DadosPessoaisDTO {

    String cnh;
    String cpf;
    String nome;
    String nomeMae;
    String nomePai;
    String rg;
    TipoSexo sexo;
    String tituloEleitor;
}
