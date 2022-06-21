package contaCorrente;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    Double saldo;
    Double chequeEspecial;

    public void imprimirContaCorrente(){
            System.out.printf("""
                Dados da conta:
                Nome: %s
                Numero da Conta: %s
                Agencia: %s
                Saldo: %s
                Cheque Especial: %s
                """,cliente.nome,numeroConta,agencia,saldo,chequeEspecial);
    }
    public Boolean sacar(Double valor){
        if(this.saldo+this.chequeEspecial < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Saque no valor de " +valor);
        this.saldo -= valor;
        return true;
    }
    public Boolean depositar(Double valor){
        if(valor <=0){
            System.out.println("Não e possivel depositar este valor!");
            return false;
        }
        System.out.println("Deposito no valor de " +valor );
        this.saldo += valor;
        return true;
    }

    public Double retornarSaldoComChequeEspecial(){
        return this.saldo + this.chequeEspecial;
    }

    public Boolean transferir(ContaCorrente conta, Double valor){
        if(this.saldo+this.chequeEspecial < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Transferencia no valor de " +valor);
        this.saldo -= valor;
        conta.saldo += valor;
        return true;
    }

}
