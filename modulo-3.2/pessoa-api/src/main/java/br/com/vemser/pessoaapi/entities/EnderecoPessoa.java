package br.com.vemser.pessoaapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ENDERECO_PESSOA")
public class EnderecoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "ID_ENDERECO", nullable = false)
    private Integer id;

    @Column(name = "TIPO", nullable = false)
    private TipoEndereco tipoEndereco;

    @Column(name = "LOGRADOURO", nullable = false, length = 200)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false)
    private Long numero;

    @Column(name = "COMPLEMENTO", length = 200)
    private String complemento;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;

    @Column(name = "CIDADE", nullable = false, length = 300)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 100)
    private String estado;

    @Column(name = "PAIS", nullable = false, length = 100)
    private String pais;

}
