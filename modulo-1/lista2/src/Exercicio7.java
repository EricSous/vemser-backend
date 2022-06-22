import java.util.Scanner;

public class Exercicio7 {
//    7. Leia uma matriz 4 x 4, conte e escreva quantos valores maiores que 10 ela possui.

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];
        Scanner sc = new Scanner(System.in);
        int contadorMaiorQueDez = 0;
        //Leitura da matriz:
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Digite um numero: ");
                matriz[i][j] = sc.nextInt();
                sc.nextLine();
            }
        }
        for (int[] ints : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                if (ints[j] > 10) {
                    contadorMaiorQueDez++;
                }
            }
        }
        System.out.println("Existem: " + contadorMaiorQueDez + " numeros maiores que 10");
    }
}
