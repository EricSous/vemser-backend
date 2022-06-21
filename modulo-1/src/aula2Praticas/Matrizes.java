package aula2Praticas;

public class Matrizes {
    public static void main(String[] args) {
        int[][] matriz = {
                {70,20},
                {15,29}
        };
        int a = matriz[0][0];
        int b = matriz[0][1];
        int c = matriz[1][0];
        int d = matriz[1][1];
        int somaPrimeiraLinha = a+b;
        int somaSegundaLinha = c+d;

        System.out.println(somaPrimeiraLinha+somaSegundaLinha);
        System.out.println(somaPrimeiraLinha);
        System.out.println(somaSegundaLinha);
        System.out.println(somaPrimeiraLinha-somaSegundaLinha);

    }
}
