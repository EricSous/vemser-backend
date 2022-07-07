package br.com.vemser.pessoaapi.entities;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idEndereco;

    private Integer idPessoa;

    @NotNull
    @Size(max = 250)
    private String logradouro;

    private String complemento;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;

    @NotNull
    @NotEmpty
    @Size(max = 8)
    private String cep;

    @NotNull
    private TipoEndereco tipoEndereco;

    @NotNull
    private Integer numero;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, Integer idPessoa, String logradouro, String complemento, String cidade, String estado, String cep, TipoEndereco tipoEndereco, Integer numero, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipoEndereco = tipoEndereco;
        this.numero = numero;
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String pais) {
        this.cep = pais;
    }
}
