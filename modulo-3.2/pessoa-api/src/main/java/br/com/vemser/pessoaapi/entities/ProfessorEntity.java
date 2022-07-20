package br.com.vemser.pessoaapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PROFESSOR")
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorId id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private Integer salario;


}
