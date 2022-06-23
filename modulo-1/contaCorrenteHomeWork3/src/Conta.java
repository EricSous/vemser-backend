public abstract class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private Double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente, String numeroConta, int agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
        System.out.println("Deposito no valor de " +valor +" na conta do "+ getCliente().getNome());
        setSaldo(getSaldo() + valor);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if(valor <=0){
            System.out.println("Transferencia invalida");
            return false;
        }else if(getSaldo()< valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        System.out.println("Transferencia no valor de " +valor);
        setSaldo(getSaldo() - valor);
        conta.setSaldo(conta.getSaldo() + valor);
        return true;
    }
}
