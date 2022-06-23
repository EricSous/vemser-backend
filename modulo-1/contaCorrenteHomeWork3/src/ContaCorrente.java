public class ContaCorrente extends Conta implements Imprimir{
    private Double chequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial(){
        return getSaldo() + this.chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo()+this.chequeEspecial < valor){
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
        System.out.println("Deposito no valor de " +valor +" na conta do "+ getCliente().getNome());
        setSaldo(getSaldo() + valor);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if(valor <=0){
            System.out.println("Transferencia invalida");
            return false;
        }else if(getSaldo()+this.chequeEspecial < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Transferencia no valor de " +valor);
        setSaldo(getSaldo() - valor);
        conta.setSaldo(conta.getSaldo() + valor);
        return true;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Dados da conta:
                Nome: %s
                Numero da Conta: %s
                Agencia: %s
                Saldo: %s
                Cheque Especial: %s""",getCliente().getNome(),getNumeroConta(),getAgencia(),getSaldo(),chequeEspecial);
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
