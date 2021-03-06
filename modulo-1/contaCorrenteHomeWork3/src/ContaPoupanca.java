public class ContaPoupanca extends Conta implements Imprimir{
    static final double JUROS_MENSAL= 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
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
                Juros Mensal: %s""",getCliente().getNome(),getNumeroConta(),getAgencia(),getSaldo(),JUROS_MENSAL);
    }

}
