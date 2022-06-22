package aula2Praticas;

import java.util.Scanner;

public class Aula2Pratica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double[] somaEMedia = new Double[3];
        System.out.println("Digite 3 numeros para o Array: ");
        somaEMedia[0] = sc.nextDouble();
        sc.nextLine();
        somaEMedia[1] = sc.nextDouble();
        sc.nextLine();
        somaEMedia[2] = sc.nextDouble();
        sc.nextLine();

        Double t =0.0;
        for (int i = 0; i <= somaEMedia.length -1;i++) {
            t += somaEMedia[i];
        }
        System.out.println("Soma dos valores: " +t);
        System.out.printf("Media dos valores: %.2f", t/somaEMedia.length);
    }
}
