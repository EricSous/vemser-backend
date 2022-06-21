package aula2Praticas;

import java.util.Scanner;

public class ForPratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de numeros para adicionar a lista: ");
        int total = sc.nextInt();
        sc.nextLine();
        Double[] array = new Double[total];

        for(int i = 0; i < total; i++){
            System.out.println("Digite o valor para posição "+ i +":");
            array[i] = sc.nextDouble();
            sc.nextLine();
        }
        Double somaTot = 0.0;
        for(Double i : array){
            somaTot +=i;
        }
        System.out.println("Media" + somaTot/array.length);
    }
}
