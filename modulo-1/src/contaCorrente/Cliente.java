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
                Dados do cliente:
                Nome:%s
                Cpf:%s
                 """, this.nome, this.cpf);
    }
}
