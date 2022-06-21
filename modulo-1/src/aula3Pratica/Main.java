package aula3Pratica;

public class Main {
    public static void main(String[] args) {

        Pessoa primeiraPessoa = new Pessoa();

        primeiraPessoa.nome = "Joao";
        primeiraPessoa.sobrenome = "Silva";
        primeiraPessoa.idade = 18;
        primeiraPessoa.numero = "985469988";


        Pessoa segundaPessoa = new Pessoa();

        segundaPessoa.nome = "Joana";
        segundaPessoa.sobrenome = "Maria";
        segundaPessoa.idade = 15;
        segundaPessoa.numero = "988769988";
        System.out.println(primeiraPessoa.maiorDeIdade());

        primeiraPessoa.conversar("Lucas");
        System.out.println(primeiraPessoa.retornarNomeCompleto());
        System.out.println(segundaPessoa.retornarNomeCompleto());

        primeiraPessoa.mandarWhatsApp(segundaPessoa, "Vamos Sair hoje?");
        }
}
