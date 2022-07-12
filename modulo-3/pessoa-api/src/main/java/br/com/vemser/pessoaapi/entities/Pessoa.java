package br.com.vemser.pessoaapi.entities;

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

    @NotEmpty
    @NotNull
    private String nome;

    @Past
    @NotNull
    private Date dataNascimento;

    @Size(max = 11, min = 11)
    @NotNull
    private String cpf;

    @NotNull
    private String email;


}
