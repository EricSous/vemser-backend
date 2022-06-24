public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contato = new Contato[2];
    private Endereco[] endereco = new Endereco[2];

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Contato[] contato, Endereco[] endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContato() {
        return contato;
    }

    public void setContato(Contato[] contato) {
        this.contato = contato;
    }

    public Endereco[] getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco[] endereco) {
        this.endereco = endereco;
    }

    public void imprimirContatos() {
        for (Contato value : contato) {
            if (value == null) {
                continue;
            }
            value.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco value : endereco) {
            if (value == null) {
                continue;
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
