import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contato = new ArrayList<>();
    private ArrayList<Endereco> endereco = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contato, ArrayList<Endereco> endereco) {
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

    public ArrayList<Contato> getContato() {
        return contato;
    }

    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
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
