public class ContaPagamento extends Conta implements Imprimir{
    static final double TAXA_SAQUE = 4.25;


    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Dados da conta:
                Nome: %s
                Numero da Conta: %s
                Agencia: %s
                Saldo: %s
                Taxa para pagamentos: %s""",getCliente().getNome(),getNumeroConta(),getAgencia(),getSaldo(),TAXA_SAQUE);
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo()  < valor + TAXA_SAQUE){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Saque no valor de " +valor);
        setSaldo(getSaldo() - valor - TAXA_SAQUE);
        return true;
    }

}
