package contaCorrente;

public class Cliente {
    String nome;
    String cpf;
    Contato contato;
    Endereco endereco;

    public void imprimirContatos() {
        this.contato.imprimirContato();
    }

    public void imprimirEnderecos() {
        this.endereco.imprimirEndereco();
    }

    public void imprimirClientes() {
        System.out.printf("""
                Nome:%s
                Cpf:%s
                Contato:%s
                Endereço:%s
                 """, this.nome, this.cpf, this.contato, this.endereco);
    }
}
