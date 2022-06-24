import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contato> contatosJoao = new ArrayList<>();
        Contato contato1 = new Contato("Telefone do cliente","61 99140-5346",1);
        contatosJoao.add(contato1);
        Contato contato2 = new Contato("Telefone da casa da mae do cliente","61 3599-5660",2);
        contatosJoao.add(contato2);
        ArrayList<Endereco> enderecosJoao = new ArrayList<>();
        Endereco endereco1Joao = new Endereco(1,"qr",105,"Em frente ao hospital","723222-578","Brasilia","Distrito Federal","Brasil");
        enderecosJoao.add(endereco1Joao);
        Cliente clienteJoao = new Cliente("João da silva","870.227.650-06",contatosJoao,enderecosJoao);

        ArrayList<Contato> contatosLucas = new ArrayList<>();
        Contato contatosLucas1 = new Contato("Telefone da casa do cliente","61 3598-6314",2);
        Contato contatosLucas2 = new Contato("Telefone celular do cliente","61 99999-9999",1);
        contatosLucas.add(contatosLucas1);
        contatosLucas.add(contatosLucas2);
        ArrayList<Endereco> enderecosLucas = new ArrayList<>();
        Endereco enderecoLucas1 = new Endereco(2,"São joao",93,"Em frente a igreja","71922-428","Salvador","Bahia","Brasil");
        Cliente clienteLucas = new Cliente("Lucas santos","005.224.660-44",contatosLucas,enderecosLucas);

        ContaCorrente contaCCJoao = new ContaCorrente(clienteJoao,"153463-5",1568,0.0,200.0);
        ContaPoupanca contaPoupJoao = new ContaPoupanca(clienteJoao,"14963-1",3594,0.0);

        ContaPagamento contaPagLucas = new ContaPagamento(clienteLucas,"49953-1",3500,0.0);


        System.out.println("Deposito " +contaPoupJoao.depositar(500.0));
        System.out.println("Novo saldo: " +contaPoupJoao.getSaldo());
        System.out.print("\n");
        System.out.println("Saque " +contaPoupJoao.sacar(600.0));
        System.out.println("Novo saldo: " +contaPoupJoao.getSaldo());
        System.out.println("Saque " +contaPoupJoao.sacar(200.0));
        contaCCJoao.depositar(-500.0);
        System.out.println("Novo saldo: " +contaPoupJoao.getSaldo()+"\n");

        System.out.println("Deposito " +contaCCJoao.depositar(1500.0));
        System.out.println("Transferência da conta corrente para Poupança João: "+contaCCJoao.transferir(contaPoupJoao,0.0));
        System.out.println("Saldo novo da conta corrente do João: " + contaCCJoao.getSaldo());
        System.out.print("\n");
        System.out.println("Saldo com cheque especial do João: "+ contaCCJoao.retornarSaldoComChequeEspecial());
        System.out.print("\n");

        contaPoupJoao.creditarTaxa();
        System.out.println("Saldo novo do Joao com juros na conta poupança: " + contaPoupJoao.getSaldo());

        System.out.println("Sacando dinheiro da conta do lucas "+ contaPagLucas.sacar(100));
        System.out.println("Saldo do Lucas: "+ contaPagLucas.getSaldo());
        System.out.println("Depositando na conta do Lucas: "+ contaPagLucas.depositar(1500));
        System.out.println("Transferencia do Lucas para o Joao: " +contaPagLucas.transferir(contaCCJoao, 500.0));
        System.out.print("\n");


        contaCCJoao.imprimir();
        System.out.println("\n");
        contaPoupJoao.imprimir();
        System.out.println("\n");
        contaPagLucas.imprimir();



    }
}
