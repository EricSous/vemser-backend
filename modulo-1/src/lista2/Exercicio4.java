package lista2;

import java.util.Scanner;

public class Exercicio4 {

//    4. Desenvolver um algoritmo que peça três números e informe a posição do menor
//número digitado (usar vetor).

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[3];
        int guarda = 0;

        for(int i = 0; i < vetor.length ;i++){
            System.out.println("Digite um numero: ");
            vetor[i] = sc.nextInt();
            sc.nextLine();
        }
        guarda = vetor[0];
        for(int i = 0; i < vetor.length ;i++){
            if(vetor[i] <= guarda){
            }else{
                guarda = vetor[i];
            }
        }
        System.out.println("O maior numero é: " + guarda);
    }
}
