package br.com.vemser.pessoaapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "ID_CONTATO", nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    private PessoaEntity pessoa;

    @Column(name = "TIPO")
    private TipoContato tipoContato;

    @Column(name = "NUMERO", length = 14)
    private String numero;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

}
