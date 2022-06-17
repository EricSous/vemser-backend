import java.util.Scanner;

public class Exercicio3 {
//    . Uma lanchonete precisa de um programa calcule o troco a ser dado para o cliente:
//    a. Precisamos de 2 entradas: Valor total consumido e valor pago pelo cliente
//    b. Se o valor pago for menor do que o total consumido deve exibir uma mensagem: “o valor pago
//    deve ser maior ou igual ao valor consumido”
//    c. Se o valor pago for menor ou igual ao total consumido, calcular o troco ao cliente

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor gasto: ");
        float gasto = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite o valor pago: ");
        float pago = sc.nextFloat();
        sc.nextLine();
        if(pago < gasto){
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        }else if(pago == gasto){
            System.out.println("Valor gasto igual valor pago nao e necessario troco");
        }else if(pago > gasto){
            float troco = pago - gasto;
            System.out.println("O seu troco e de: R$" + troco);

        }
    }

}
