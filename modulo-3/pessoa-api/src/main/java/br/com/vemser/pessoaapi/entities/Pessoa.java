package br.com.vemser.pessoaapi.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    private String nome;

    private Date dataNascimento;

    private String cpf;

    private String email;


}
