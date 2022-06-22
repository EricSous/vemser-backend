import java.util.Scanner;

public class Exercicio2 {
//    2. Isso lembrará uma brincadeira de colégio...Uma pessoa escolhe um número e pede
//para outro adivinhar, faça um programa que tenha a mesma ideia, você informará um
//número e quando alguém for tentar adivinhá-lo o programa deverá informar se
//acertou o número ou se errou, se errou o programa deverá apresentar uma das
//seguintes frases: O número a ser encontrado é menor do que você digitou ou O
//número a ser encontrado é maior do que você digitou.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        Double qualquer = sc.nextDouble();
        System.out.println("Qual o numero que seu amigo digitou? ");
        Double chute = sc.nextDouble();
        do{
            if(qualquer.equals(chute)){
                System.out.println("Numero correto");
            }else if(chute > qualquer){
                System.out.println("O numero e maior do que o digitado");
            }else if(chute < qualquer){
                System.out.println("O numero e menor do que o digitado");
            }
            System.out.println("Digite outro numero: ");
            chute = sc.nextDouble();


        }while (!qualquer.equals(chute));

    }
}
