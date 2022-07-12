package br.com.vemser.pessoaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {
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


    @Override
    public String toString() {
        return "PessoaDTO{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
