import java.util.Scanner;

public class Exercicio5 {
//    5. Crie um programa que calcule o salário do usuário, para isso será necessário:
//    a. passar o valor da hora em R$;
//    b. o número de horas normais trabalhas;
//    c. o número de horas extras 50%;
//    d. o número de horas extras 100%;
//    e. em seguida exiba o salário bruto... Fórmula: (b * a) + (c * a * 1.5) + (d * a * 2).

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o valor por Hora: ");
    Float valorHora = sc.nextFloat();
    sc.nextLine();
    System.out.println("Digite as horas mensais trabalhadas: ");
    Float horasTrabalhadasMensal = sc.nextFloat();
    sc.nextLine();
    System.out.println("Digite o total de horas extras trabalhadas equivalente a 50%: ");
    Float horasExtras50 = sc.nextFloat();
    sc.nextLine();
    System.out.println("Digite o total de horas extras trabalhadas equivalentes a 100%: ");
    Float horasExtras100 = sc.nextFloat();
    sc.nextLine();

    System.out.println((horasTrabalhadasMensal * valorHora) + (horasExtras50 * valorHora * 1.5) + (horasExtras100 * valorHora * 2));

}

}
