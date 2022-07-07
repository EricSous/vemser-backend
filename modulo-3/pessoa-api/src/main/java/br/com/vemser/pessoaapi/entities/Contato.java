package br.com.vemser.pessoaapi.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contato {

        private Integer idContato;

        private Integer idPessoa;

        @NotNull
        @Size(max = 13)
        private String numero;

        @NotNull
        @NotEmpty
        private String descricao;

        @NotNull
        private TipoContato tipoDeContato;

    public Contato() {
    }

    public Contato(Integer idContato, Integer idPessoa, String numero, String descricao, TipoContato tipoDeContato) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoDeContato = tipoDeContato;
    }

    public TipoContato getTipoDeContato() {
        return tipoDeContato;
    }

    public void setTipoDeContato(TipoContato tipoDeContato) {
        this.tipoDeContato = tipoDeContato;
    }

    public Integer getIdContato() {
            return idContato;
        }

        public void setIdContato(Integer idContato) {
            this.idContato = idContato;
        }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
