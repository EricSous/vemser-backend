package contaCorrente;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];

    public void imprimirContatos() {
        for (Contato value : contato) {
            if (value == null) {
                return;
            }
            value.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco value : endereco) {
            if (value == null) {
                return;
            }
            value.imprimirEndereco();
        }
    }

    public void imprimirClientes() {
        System.out.printf("""
                Dados do cliente:
                Nome:%s
                Cpf:%s
                 """, this.nome, this.cpf);
    }
}
