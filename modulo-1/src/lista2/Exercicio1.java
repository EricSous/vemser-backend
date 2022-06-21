package lista2;

import java.util.Scanner;

public class Exercicio1 {
    //    1. Elabore um programa para uma papelaria que leia o nome e o valor de um produto.
//    Em seguida, faça uma lista de 1 a 10 unidades do produto, sendo que o desconto de
//    uma unidade desse produto seja de 5% e de 2 seja 10% de 3 = 15% etc... Até
//    alcançar os 50% de desconto
//    para entender melhor, um exemplo:
//    Produto.: lápis
//    Preço R$.: 2,00
//    Promoção: lápis
//------------------------
//        1 x R$ 1,90 = R$ 1,90
//            2 x R$ 1,80 = R$ 3,60
//            3 x R$ 1,70 = R$ 5,10
//            4 x R$ 1,60 = R$ 6,40
//            5 x R$ 1,50 = R$ 7,50
//            6 x R$ 1,40 = R$ 8,40
//            7 x R$ 1,30 = R$ 9,10
//            8 x R$ 1,20 = R$ 9,60
//            9 x R$ 1,10 = R$ 9,90
//            10 x R$ 1,00 = R$ 10,00
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o produto a ser adicionado ?");
        String produto = sc.nextLine();
        System.out.println("Qual o valor do produto? ");
        double valor = sc.nextDouble();

        System.out.printf("""
                Produto: %s
                Preço: R$ %s
                Promoção: %s
                """, produto, valor, produto);

        double incremento = 0.05;
        for (double i = 1.0; i <= 10; i++) {
            double desconto = (valor * incremento);
            double valorTotComDesc = valor - (desconto);
            double total = valorTotComDesc * i;
            System.out.println(i + " x " + "R$" + valorTotComDesc + " = " + "R$ " + total);
            incremento += 0.05;
        }

    }
}
