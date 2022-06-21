package aula3Pratica;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String numero;


    public void conversar(String nome) {
        System.out.println(this.nome + " Conversou com " + nome);
    }

    public String retornarNomeCompleto() {
        return nome +" "+ sobrenome;
    }

    public Boolean maiorDeIdade() {
        return this.idade >= 18;
    }

    public void mandarWhatsApp(Pessoa pessoa,String mensagem) {
        System.out.println(this.nome +" Enviou a mensagem: "+mensagem +" para: " + pessoa.nome);

    }

}
