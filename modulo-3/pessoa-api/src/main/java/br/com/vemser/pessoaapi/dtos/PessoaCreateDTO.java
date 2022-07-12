package br.com.vemser.pessoaapi.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PessoaCreateDTO {

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
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
