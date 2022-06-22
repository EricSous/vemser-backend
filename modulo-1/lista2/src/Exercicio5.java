import java.util.Scanner;

public class Exercicio5 {
//    5. Faça um algoritmo que leia 20 valores e os escreva na ordem contrária à que foram
//digitados.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um numero: ");
            vetor[i] = sc.nextInt();
        }

        for (int i = vetor.length -1; i != -1; i--) {
            System.out.println(vetor[i]);
        }
    }
}
