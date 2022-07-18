package br.com.vemser.pessoaapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA", nullable = false)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "EMAIL", nullable = false)
    private String email;

}
