package aula2Praticas;

import java.util.Objects;
import java.util.Scanner;

public class WhilePratica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = "";
        while (!Objects.equals(palavra, "fim")){
            System.out.println("\nDigite uma palavra: ");
            palavra = sc.nextLine();
            System.out.println("\nA palavra é " +palavra);
        }
    }
}
