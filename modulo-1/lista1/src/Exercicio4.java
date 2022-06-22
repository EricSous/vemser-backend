package lista1;

import java.util.Scanner;

public class Exercicio4 {
//    4. Criar um algoritmo onde o usuário possa escolher o estado e haverá uma lista com determinadas cidades
//    daquele aquele estado. O usuário poderá escolher uma cidade, após escolher a cidade desejada irá
//    aparecer dados sobre a mesma (população, principal festa, IDH...).
//    OBS: Deverá conter 3 estados e para cada estado 2 cidades.

    // Utilizado java 17 para efetuar exercicio, para ficar mais organizado utilizei a modularização e arrow.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um estado: (São paulo, Bahia ou Minas Gerais)");
        String estado = sc.nextLine();

        switch (estado) {
            case "São paulo" -> {
                System.out.println("Escolha uma cidade: (São paulo ou Guarulhos)");
                String cidade = sc.nextLine();
                switch (cidade) {
                    case "São paulo" -> System.out.println("""
                            A população e de aproximadamente 12.33 milhões de habitantes
                            A principal festa de são paulo e o Carnaval
                            Com um IDH aproximado de 0,783""");
                    case "Guarulhos" -> System.out.println("""
                            A população e de aproximadamente 1.3 milhões de habitantes.
                            A principal festa de Guarulhos e a Procissão do Fogaréu
                            Com um IDH aproximado de 0,763""");
                }
            }
            case "Bahia" -> {
                System.out.println("Escolha uma cidade: (Salvador ou Porto Seguro)");
                String cidade = sc.nextLine();
                switch (cidade) {
                    case "Salvador" -> System.out.println("""
                            A população e de aproximadamente 2.9 milhões de habitantes
                            A principal festa de Salvador e o Carnaval
                            Com um IDH aproximado de 0,791 dado de 2021""");
                    case "Porto Seguro" -> System.out.println("""
                            A população e de aproximadamente 151 mil habitantes.
                            A principal festa de Porto Seguro e o São João
                            Com um IDH aproximado de 0,676""");
                }
            }
        case "Minas Gerais" -> {
            System.out.println("Escolha uma cidade: (Patos de Minas ou Belo Horizonte)");
            String cidade = sc.nextLine();
            switch (cidade) {
                case "Patos de Minas" -> System.out.println("""
                        A população e de aproximadamente 153 mil habitantes
                        A principal festa de Patos de Minas e a Fenamilho
                        Com um IDH aproximado de 0,765 dado de 2021""");
                case "Belo Horizonte" -> System.out.println("""
                        A população e de aproximadamente 151 mil habitantes.
                        A principal festa de Belo Horizonte e a Cavalhada
                        Com um IDH aproximado de 0,810""");
            }
        }
        default -> System.out.println("Cidade invalida");
    }

}
}
