import java.util.Scanner;

public class Exercicio2 {

//    Desenvolver um algoritmo que faça a média de quatro notas e diga se o aluno está aprovado, reprovado ou
//    em exame e a média do aluno.
//0 a 5 = reprovado
//5,1 a 6,9 = em exame
//7 a 10 = aprovado

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite nota 1: ");
        Double nota1 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite nota 2: ");
        Double nota2 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite nota 3: ");
        Double nota3 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite nota 4: ");
        Double nota4 = sc.nextDouble();
        sc.nextLine();

        double media = (nota1 + nota2 + nota3 + nota4)/4;
        System.out.println("Sua media foi: " +media);
        System.out.print("Você está: ");
        if(media <= 5){
            System.out.println("reprovado");
        }else if(media >= 5.1 && media <=6.9f){
            System.out.println("em exame");
        }else if(media >= 7 && media <=10){
            System.out.println("aprovado");
        }
    }

}
