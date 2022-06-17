public class Exercicio2 {

//    Desenvolver um algoritmo que faça a média de quatro notas e diga se o aluno está aprovado, reprovado ou
//    em exame e a média do aluno.
//0 a 5 = reprovado
//5,1 a 6,9 = em exame
//7 a 10 = aprovado

    public static void main(String[] args) {
        float nota1 = 9.6f;
        float nota2 = 7.8f;
        float nota3 = 6.5f;
        float nota4 = 4.5f;

        float media = (nota1 + nota2 + nota3 + nota4)/4;
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
