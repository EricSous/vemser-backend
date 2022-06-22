import java.util.Arrays;
import java.util.Scanner;

public class Exercicio8 {
//    8. Faça um programa que leia uma matriz de 5x4 inteiros contendo as seguintes
//informações do tipo inteiro:
//a. Primeira coluna: número da matrícula
//b. Segunda coluna: media das provas
//c. Terceira coluna: média dos trabalhos
//d. Quarta coluna: nota final
//Elabore um programa que:
//a. Leia as 3 primeiras informações de cada aluno
//b. Calcule a nota final = (media das provas * 0,6 + media dos trabalhos * 0,4)
//c. Imprima a matrícula que obteve a maior nota final
//d. Imprima a média das notas finais

    public static void main(String[] args) {
        Double[][] matriz = new Double[5][4];
        Scanner sc = new Scanner(System.in);
        Double guarda = 0.0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    System.out.println("Digite o valor da matricula: ");
                    matriz[i][j] = sc.nextDouble();
                }
                if(j == 1) {
                    System.out.println("Digite o valor da media da prova do aluno: ");
                    matriz[i][j] = sc.nextDouble();
                }
                if(j == 2) {
                    System.out.println("Digite o valor da media dos trabalhos: ");
                    matriz[i][j] = sc.nextDouble();
                }
                sc.nextLine();
            }
        }

        for (int i = 0; i < 5; i++) {
            matriz[i][3] = (0.6 * matriz[i][1]) + (0.6 * matriz[i][2]);
        }

        for (int i = 0; i < 5; i++) {
            if (matriz[i][3] >= guarda) {
                guarda = matriz[i][3];
            }
        }

        System.out.println("A maior nota é: " + guarda);
        for(int i = 0; i < 5; i++){
            System.out.println("As medias finais são, posição " +i +": "+matriz[i][3]);
        }

        System.out.println(Arrays.deepToString(matriz));

    }
}
