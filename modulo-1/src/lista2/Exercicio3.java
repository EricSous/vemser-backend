package lista2;

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
        String[] nome = new String[200];
        int pessoas = 0;
        Double[] altura = new Double[200];
        Double[] idade = new Double[200];
        Double[] peso = new Double[200];

        while (!nome.equals("sair")) {
            System.out.println("Digite seu nome: ");
            nome[pessoas] = sc.nextLine();
            if (Objects.equals(nome[pessoas], "sair")) {
                break;
            }
            System.out.println("Digite sua altura: ");
            altura[pessoas] = sc.nextDouble();
            sc.nextLine();
            System.out.println("Digite sua idade: ");
            idade[pessoas] = sc.nextDouble();
            sc.nextLine();
            System.out.println("Digite seu peso: ");
            peso[pessoas] = sc.nextDouble();
            sc.nextLine();
            pessoas++;
        }
        Double guarda = 0.0;
        for (int i = 0; i < pessoas; i++) {
            if (altura[i] < guarda) {
            } else {
                guarda = altura[i];
            }
        }
        Double velho = 0.0;
        int pegarPessoaVelha = 0;
        Integer tratandoIguaisVelho = null;
        for (int i = 0; i < pessoas; i++) {
            if (idade[i] < velho) {
            } else {
                velho = idade[i];
                pegarPessoaVelha = i;
            }
            if(idade[i] == velho){
                tratandoIguaisVelho = i-1;
            }
        }
        Integer tratandoIguaisPesado = null;
        int pegarPessoaPesada = 0;
        Double pesado = 0.0;
        for (int i = 0; i < pessoas; i++) {
            if (peso[i] < pesado) {
            } else {
                pesado = peso[i];
                pegarPessoaPesada = i;
            }
            if(peso[i] == pesado){
                tratandoIguaisPesado = i-1;
            }
        }
        System.out.println("Quantidade de jogadores: " + pessoas);
        System.out.println("A maior altura e:  " + guarda);
        if(tratandoIguaisVelho != null){
            System.out.println("Os jogadores mais velhos são:  " + nome[pegarPessoaVelha] +", " +nome[tratandoIguaisVelho]);
        }else{
            System.out.println("O jogador mais velho é:  " + nome[pegarPessoaVelha]);
        }
        if(tratandoIguaisPesado != null){
            System.out.println("Os jogadores mais velhos são:  " + nome[pegarPessoaPesada] +", " +nome[tratandoIguaisPesado]);
        }else{
            System.out.println("O jogador mais pesado é:  " + nome[pegarPessoaPesada]);
        }
    }
}
