package br.com.vemser.pessoaapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PessoaCreateDTO {

    @Schema(description = "Nome da Pessoa")
    @NotEmpty
    @NotNull
    private String nome;

    @Schema(description = "Data de Nascimento")
    @Past
    @NotNull
    private Date dataNascimento;

    @Schema(description = "CPF")
    @Size(max = 11, min = 11)
    @NotNull
    private String cpf;

    @Schema(description = "Email")
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
