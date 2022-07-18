package br.com.vemser.pessoaapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "ID_CONTATO", nullable = false)
    private Integer id;

    @Column(name = "TIPO")
    private TipoContato tipoContato;

    @Column(name = "NUMERO", length = 14)
    private String numero;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "ID_PESSOA", nullable = false)
    private Integer idPessoa;

}
