package lista2;

import java.util.Scanner;

public class Exercicio6 {
//    6. Desenvolver um vetor que contenha 10 números (não será pedido ao usuário), ao
//colocar um determinado número deverá ser buscado no vetor por aquele número,
//caso não haja será necessário exibir uma mensagem dizendo que não existe aquele
//determinado número digitado.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = {1,5,6,7,9,10,15,26,31,17};
        System.out.println("Digite um numero: ");
        int numero = sc.nextInt();
        sc.nextLine();
        boolean existe= false;
        for (int j : vetor) {
            if (numero == j) {
                existe = true;
                break;
            }
        }
        if(existe){
            System.out.println("Numero existe no vetor");
        }else {
            System.out.println("Numero não existe no vetor");
        }
    }
}
