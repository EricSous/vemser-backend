public class Main {
    public static void main(String[] args) {
        Contato[] contatosJoao = new Contato[2];
        contatosJoao[0] = new Contato("Telefone do cliente","61 99140-5346",1);
        contatosJoao[1] = new Contato("Telefone da casa da mae do cliente","61 3599-5660",2);
        Endereco[] enderecosJoao = new Endereco[2];
        enderecosJoao[0] = new Endereco(1,"qr",105,"Em frente ao hospital","723222-578","Brasilia","Distrito Federal","Brasil");
        Cliente clienteJoao = new Cliente("João da silva","870.227.650-06",contatosJoao,enderecosJoao);

        Contato[] contatosLucas = new Contato[2];
        contatosLucas[0] = new Contato("Telefone da casa do cliente","61 3598-6314",2);
        contatosLucas[1] = new Contato("Telefone celular do cliente","61 99999-9999",1);
        Endereco[] enderecosLucas = new Endereco[2];
        enderecosLucas[0] = new Endereco(2,"São joao",93,"Em frente a igreja","71922-428","Salvador","Bahia","Brasil");
        Cliente clienteLucas = new Cliente("Lucas santos","005.224.660-44",contatosLucas,enderecosLucas);

        ContaCorrente contaJoao = new ContaCorrente(clienteJoao,"153463-5",1568,0.0,200.0);

        ContaPoupanca contaLucas = new ContaPoupanca(clienteLucas,"14963-1",3594,0.0);

        System.out.println("Deposito " +contaJoao.depositar(500.0));
        System.out.println("Novo saldo: " +contaJoao.getSaldo());
        System.out.println("Saque " +contaJoao.sacar(600.0));
        System.out.println("Novo saldo: " +contaJoao.getSaldo());
        System.out.println("Saque " +contaJoao.sacar(200.0));
        contaJoao.depositar(-500.0);
        System.out.println("Novo saldo: " +contaJoao.getSaldo()+"\n");

        System.out.println("Deposito " +contaLucas.depositar(1500.0));
        System.out.println("Transferencia: "+contaLucas.transferir(contaJoao,20.0));
        System.out.println("Saldo novo do João: " + contaJoao.getSaldo());
        System.out.println("Saldo com cheque especial do João: "+ contaJoao.retornarSaldoComChequeEspecial());
        System.out.println("Saldo novo do Lucas: " + contaLucas.getSaldo());
        System.out.println("Saldo com cheque especial do Lucas: "+ contaJoao.retornarSaldoComChequeEspecial());

        clienteJoao.imprimirClientes();
        System.out.println("\n");
        clienteJoao.imprimirContatos();
        System.out.println("\n");
        clienteJoao.imprimirEnderecos();
        System.out.println("\n");
        contaJoao.imprimir();
        System.out.println("\n");
        clienteLucas.imprimirClientes();
        System.out.println("\n");
        clienteLucas.imprimirContatos();
        System.out.println("\n");
        clienteLucas.imprimirEnderecos();
        System.out.println("\n");
        contaLucas.imprimir();

    }
}
