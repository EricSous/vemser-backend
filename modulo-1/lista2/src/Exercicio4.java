import java.util.Scanner;

public class Exercicio4 {

//    4. Desenvolver um algoritmo que peça três números e informe a posição do menor
//número digitado (usar vetor).

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[3];
        int guardaMenorValor;
        int count =0;

        for(int i = 0; i < vetor.length ;i++){
            System.out.println("Digite um numero: ");
            vetor[i] = sc.nextInt();
            sc.nextLine();
        }

        guardaMenorValor = vetor[0];
        for (int i : vetor) {
            if (i <= guardaMenorValor) {
                guardaMenorValor = i;
            }
        }
        for(int i = 0; i < vetor.length ;i++){
            if(vetor[i] == guardaMenorValor){
                count = i + 1;
            }
        }
        System.out.println("O menor numero é: " + guardaMenorValor);
        System.out.println("Está no " + count + "º Lugar");
    }
}
