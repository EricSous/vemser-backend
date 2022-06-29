package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static class Calcula{

        public int divisao(int a, int b){
            try {
                return a / b;
            }catch (ArithmeticException ax){
                ax.printStackTrace();
            }finally {
                System.out.println("Passou finally");
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calcula calcula = new Calcula();
        try {
            System.out.println("Escreva os valores");
            int a = sc.nextInt();
            sc.nextLine();
            int b = sc.nextInt();
            sc.nextLine();
            System.out.println(calcula.divisao(a, b));
        }catch (InputMismatchException ix){
            System.out.println("Escreva um inteiro");
            int a = sc.nextInt();
            sc.nextLine();
            int b = sc.nextInt();
            sc.nextLine();
            System.out.println(calcula.divisao(a, b));
        }finally {
            System.out.println("Passou aq");
        }


    }

}
