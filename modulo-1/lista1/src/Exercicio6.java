package lista1;

import java.util.Scanner;

public class Exercicio6 {
    //    6. Criar um tradutor que traduza as seguintes palavras de inglês para português e de português para inglês.
//            Cachorro Dog
//    Tempo Time
//    Amor Love
//    Cidade City
//    Feliz Happy
//    Triste Sad
//    Deveria Should
//    Poderia Could
//    OBS: Caso o usuário informe alguma outra palavra o programa deverá informar a seguinte mensagem: Essa
//    palavra não é válida.
//    OBS2: traduzir de inglês para português e de português para inglês
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual palavra você deseja traduzir? (Tempo, Time, Amor, Love, Cidade, City, Feliz, Happy, Triste, Sad, Deveria, Should, Poderia ou Could)");
        String palavra = sc.nextLine();
        switch (palavra) {
            case "Tempo" -> System.out.println("Time");
            case "Amor" -> System.out.println("Love");
            case "Cidade" -> System.out.println("City");
            case "Feliz" -> System.out.println("Happy");
            case "Triste" -> System.out.println("Sad");
            case "Deveria" -> System.out.println("Should");
            case "Poderia" -> System.out.println("Could");
            case "Time" -> System.out.println("Tempo");
            case "Love" -> System.out.println("Amor");
            case "City" -> System.out.println("Cidade");
            case "Happy" -> System.out.println("Feliz");
            case "Sad" -> System.out.println("Triste");
            case "Should" -> System.out.println("Deveria");
            case "Could" -> System.out.println("Poderia");
            default -> System.out.println("Essa palavra não é válida.\n");
        }

    }
}
