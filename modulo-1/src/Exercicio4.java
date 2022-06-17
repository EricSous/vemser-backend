import java.util.Scanner;

public class Exercicio4 {
//    4. Criar um algoritmo onde o usuário possa escolher o estado e haverá uma lista com determinadas cidades
//    daquele aquele estado. O usuário poderá escolher uma cidade, após escolher a cidade desejada irá
//    aparecer dados sobre a mesma (população, principal festa, IDH...).
//    OBS: Deverá conter 3 estados e para cada estado 2 cidades.

// Utilizado java 17 para efetuar exercicio, para ficar mais organizado utilizei a modularização e arrow.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma cidade: (São paulo, Salvador ou Patos de Minas)");
        String cidade = sc.nextLine();
        switch (cidade) {
            case "São paulo" -> System.out.println("""
                    A população e de aproximadamente 12.33 milhões de habitantes
                    A principal festa de são paulo e o Carnaval
                    Com um IDH aproximado de 0,783""");
            case "Salvador" -> System.out.println("""
                    A população e de aproximadamente 2.9 milhões de habitantes
                    A principal festa de Salvador e o Carnaval
                    Com um IDH aproximado de 0,791 2021""");
            case "Patos de Minas" -> System.out.println("""
                    A população e de aproximadamente 153 mil habitantes
                    A principal festa de Patos de Minas e a Fenamilho
                    Com um IDH aproximado de 0,765 dado de 2021""");
            default -> System.out.println("Cidade invalida");
        }

    }
}
