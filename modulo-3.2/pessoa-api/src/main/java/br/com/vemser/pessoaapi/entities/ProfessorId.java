package br.com.vemser.pessoaapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class ProfessorId implements Serializable {

    @Column(name = "ID_PROFESSOR", nullable = false)
    private Long idProfessor;
    @Column(name = "ID_UNIVERSIDADE", nullable = false)
    private Long idUniversidade;


}
