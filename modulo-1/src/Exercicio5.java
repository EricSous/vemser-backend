public class Exercicio5 {
//    5. Crie um programa que calcule o salário do usuário, para isso será necessário:
//    a. passar o valor da hora em R$;
//    b. o número de horas normais trabalhas;
//    c. o número de horas extras 50%;
//    d. o número de horas extras 100%;
//    e. em seguida exiba o salário bruto... Fórmula: (b * a) + (c * a * 1.5) + (d * a * 2).

public static void main(String[] args) {
    Float valorHora = 27.6f;
    Float horasTrabalhadasMensal = 160f;
    Float horasExtras50 = 10f;
    Float horasExtras100 = 15f;
    System.out.println((horasTrabalhadasMensal * valorHora) + (horasExtras50 * valorHora * 1.5) + (horasExtras100 * valorHora * 2));

}

}
