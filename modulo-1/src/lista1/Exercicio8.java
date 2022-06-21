package lista1;

import java.util.Scanner;

public class Exercicio8 {
//    8. Escreva um algoritmo para ler as dimensões de um retângulo (base e altura), calcular e escrever a área do
//    retângulo.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva a base do retângulo: ");
        int base = sc.nextInt();
        sc.nextLine();
        System.out.println("Escreva a altura do retângulo: ");
        int altura = sc.nextInt();
        sc.nextLine();

        System.out.println("A área do retângulo é: " + base*altura);
    }
}
