import java.util.Scanner;

public class Exercicio1 {

//    1. Desenvolver um algoritmo que exiba as seguintes informações, porém o que está sublinhado será
//    solicitado ao usuário (por meio do Scanner).
//    EXEMPLO: Olá seu nome é João, você tem 16 anos, é da cidade de Florianópolis, situada
//    no estado de Santa Catarina.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite sua cidade:");
        String cidade = sc.nextLine();
        System.out.println("Digite seu estado:");
        String estado = sc.nextLine();
        System.out.println("Olá seu nome é " + nome + ", você tem " + idade
                + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + "");


    }
}
