public class ContaPoupanca extends Conta implements Imprimir{
    static final double JUROS_MENSAL= 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo() < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Saque no valor de " +valor);
        setSaldo(getSaldo() - valor);
        return true;
    }

    @Override
    public boolean depositar(double valor) {
        if(valor <=0){
            System.out.println("Não e possivel depositar este valor!");
            return false;
        }
        System.out.println("Deposito no valor de " +valor );
        setSaldo(getSaldo() + valor);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if(valor <=0){
            System.out.println("Transferencia invalida");
            return false;
        }else if(getSaldo() < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Transferencia no valor de " +valor);
        setSaldo(getSaldo() - valor);
        conta.setSaldo(conta.getSaldo() + valor);
        return true;
    }

    public void creditarTaxa(){
        setSaldo(getSaldo()*JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Dados da conta:
                Nome: %s
                Numero da Conta: %s
                Agencia: %s
                Saldo: %s
                Juros Mensal: %s
                """,getCliente().getNome(),getNumeroConta(),getAgencia(),getSaldo(),JUROS_MENSAL);
    }
}
