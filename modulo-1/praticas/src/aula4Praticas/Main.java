package aula4Praticas;

public class Main {
    public static void main(String[] args) {


        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();
        Multiplicacao multiplicacao = new Multiplicacao();
        Divisao divisao = new Divisao();
        System.out.println(soma.calcula(10, 15));
        System.out.println(soma.calcula(10.0, 15.0,18.0));
        System.out.println(subtracao.calcula(10, 15));
        System.out.println(subtracao.calcula(10.0, 15.0,18.0));
        System.out.println(multiplicacao.calcula(10, 15));
        System.out.println(multiplicacao.calcula(10.0, 15.0,18.0));
        System.out.println(divisao.calcula(10, 15));
        System.out.println(divisao.calcula(10.0, 15.0,18.0));

    }
}
