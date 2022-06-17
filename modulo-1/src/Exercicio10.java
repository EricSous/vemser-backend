import java.util.Scanner;

public class Exercicio10 {
//    10. Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos brancos,
//    nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao total de eleitores.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o numero de eleitores: ");
        float eleitores = sc.nextFloat();
        sc.nextLine();

        System.out.println("Digite o total de votos em branco:");
        float votosEmBranco = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite o total de votos nulos:");
        float votosNulo = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite o total de votos validos:");
        float votosValidos = sc.nextFloat();
        sc.nextLine();

        float percentual1 = (100*votosEmBranco)/eleitores;
        float percentual2 = (100*votosNulo)/eleitores;
        float percentual3 = (100*votosValidos)/eleitores;

        System.out.println("O percentual de votos em branco e de: " +percentual1 + "%");
        System.out.println("O percentual de votos em nulos e de: " +percentual2 + "%");
        System.out.println("O percentual de votos em validos e de: " +percentual3 + "%");
    }
}
