package br.com.vemser.pessoaapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCompletaDTO {

    @Schema(description = "Id da pessoa")
    private Integer id;

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

    private List<ContatoDTO> contatoDTOS;

    private List<EnderecoDTO> enderecoDTOS;

    private PetDTO petDTOS;
}
