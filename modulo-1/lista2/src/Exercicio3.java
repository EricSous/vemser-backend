import java.util.Objects;
import java.util.Scanner;

public class Exercicio3 {
//    3. Desenvolver um algoritmo que peça nome, altura, idade, peso dos jogadores de
//    basquete, enquanto o nome do jogador for diferente da palavra SAIR o programa
//    deverá pedir essas informações, após cadastrados deverá aparecer as seguintes
//    informações:
//    Quantidade de jogadores cadastrados;
//    Altura do maior Jogador;
//    Jogador mais velho;
//    Jogador mais pesado;
//    Média das alturas jogadores.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome = "";
        int pessoas = 0;
        double altura = 0.0;
        double idade = 0.0;
        double peso = 0.0;
        String nomePesado = "";
        double media = 0.0;
        String nomeIdoso = "";

        while (!nome.equals("sair")) {
            System.out.println("Digite seu nome: ");
            nome = sc.nextLine();
            if(Objects.equals(nome, "sair")){
                break;
            }
            System.out.println("Digite sua altura: ");
            double novaAltura = sc.nextDouble();
            sc.nextLine();
            if(altura <= novaAltura){
                altura = novaAltura;
            }

            System.out.println("Digite sua idade: ");
            int idadeNova = sc.nextInt();
            sc.nextLine();
            if(idade <= idadeNova){
                nomeIdoso = nome;
                idade = idadeNova;
            }
            System.out.println("Digite seu peso: ");
            double pesoNovo = sc.nextInt();
            sc.nextLine();
            if(peso <= pesoNovo){
                nomePesado = nome;
                peso = pesoNovo;
            }
            pessoas++;
            media += altura;
        }
        System.out.println("Total de jogadores é: " +pessoas);
        System.out.println("Maior altura: " + altura);
        System.out.println("Mais velho é: " + nomeIdoso );
        System.out.println("Mais pesado é: " + nomePesado );
        System.out.println("A media das alturas é: "+media/pessoas);
    }
}
