package lista1;

import java.text.ParseException;
import java.util.Scanner;

public class Exercicio9 {
//    9. Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e escreva a idade
//     dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias.

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ano em que você nasceu: ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o mes em que você nasceu: ");
        int mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o dia em que você nasceu: ");
        int dia = sc.nextInt();
        sc.nextLine();
        int dias = ((2022 - ano)*365) + ((6 -mes)*30) + (17-dia);

        System.out.println("Você tem: "+ dias +" dias de vida");

    }
}
