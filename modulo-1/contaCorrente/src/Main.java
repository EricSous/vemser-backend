public class Main {
    public static void main(String[] args) {
        Cliente clienteJoao = new Cliente();
        clienteJoao.cpf = "870.227.650-06";
        clienteJoao.nome = "João da silva";
        Contato contatoJoaoTipoUm = new Contato();
        contatoJoaoTipoUm.telefone = "61 99140-5346";
        contatoJoaoTipoUm.tipo = 1;
        contatoJoaoTipoUm.descricao = "Telefone do cliente";
        clienteJoao.contato[0] = contatoJoaoTipoUm;
        Contato contatoJoaoTipoDois = new Contato();
        contatoJoaoTipoDois.telefone = "61 3599-5660";
        contatoJoaoTipoDois.tipo = 2;
        contatoJoaoTipoDois.descricao = "Telefone da casa da mae do cliente";
        clienteJoao.contato[1] = contatoJoaoTipoDois;

        Endereco enderecoJoao = new Endereco();
        enderecoJoao.cep = "72322-578";
        enderecoJoao.cidade = "Brasilia";
        enderecoJoao.complemento = "Em frente ao hospital reginal";
        enderecoJoao.estado = "Distrito Federal";
        enderecoJoao.logradouro = "QR";
        enderecoJoao.numero = 105;
        enderecoJoao.pais = "Brasil";
        enderecoJoao.tipo = 1;

        clienteJoao.endereco[0] = enderecoJoao;


        Cliente clienteLucas = new Cliente();
        clienteLucas.cpf = "005.224.660-44";
        clienteLucas.nome = "Lucas santos";
        Contato contatoLucasTipoDois = new Contato();
        contatoLucasTipoDois.telefone = "61 3598-6314";
        contatoLucasTipoDois.tipo = 2;
        contatoLucasTipoDois.descricao = "Telefone da casa do cliente";
        clienteLucas.contato[0] = contatoLucasTipoDois;

        Contato contatoLucasTipoUm = new Contato();
        contatoLucasTipoUm.telefone = "61 99999-9999";
        contatoLucasTipoUm.tipo = 1;
        contatoLucasTipoUm.descricao = "Telefone celular do cliente";
        clienteLucas.contato[1] = contatoLucasTipoUm;

        Endereco enderecoLucas = new Endereco();
        enderecoLucas.cep = "71922-428";
        enderecoLucas.cidade = "salvador";
        enderecoLucas.complemento = "Em frente a igreja";
        enderecoLucas.estado = "Bahia";
        enderecoLucas.logradouro = "São joao";
        enderecoLucas.numero = 95;
        enderecoLucas.pais = "Brasil";
        enderecoLucas.tipo = 2;


        clienteLucas.endereco[0] = enderecoLucas;
        ContaCorrente contaJoao = new ContaCorrente();
        contaJoao.saldo = 0.0;
        contaJoao.chequeEspecial = 200.0;
        contaJoao.numeroConta = "153463-5";
        contaJoao.agencia = 1568;
        contaJoao.cliente = clienteJoao;
        ContaCorrente contaLucas = new ContaCorrente();
        contaLucas.saldo = 0.0;
        contaLucas.chequeEspecial = 200.0;
        contaLucas.numeroConta = "14963-1";
        contaLucas.agencia = 3594;
        contaLucas.cliente = clienteLucas;

        System.out.println("Deposito " +contaJoao.depositar(500.0));
        System.out.println("Novo saldo: " +contaJoao.saldo);
        System.out.println("Saque " +contaJoao.sacar(600.0));
        System.out.println("Novo saldo: " +contaJoao.saldo);
        System.out.println("Saque " +contaJoao.sacar(200.0));
        contaJoao.depositar(-500.0);
        System.out.println("Novo saldo: " +contaJoao.saldo+"\n");

        System.out.println("Deposito " +contaLucas.depositar(1500.0));
        System.out.println("Transferencia: "+contaLucas.transferir(contaJoao,300.0));
        System.out.println("Saldo novo do João: " + contaJoao.saldo);
        System.out.println("Saldo com cheque especial do João: "+ contaJoao.retornarSaldoComChequeEspecial());
        System.out.println("Saldo novo do Lucas: " + contaLucas.saldo);
        System.out.println("Saldo com cheque especial do Lucas: "+ contaLucas.retornarSaldoComChequeEspecial()+"\n");

        clienteJoao.imprimirClientes();
        System.out.println("\n");
        clienteJoao.imprimirContatos();
        System.out.println("\n");
        clienteJoao.imprimirEnderecos();
        System.out.println("\n");
        contaJoao.imprimirContaCorrente();
        System.out.println("\n");
        clienteLucas.imprimirClientes();
        System.out.println("\n");
        clienteLucas.imprimirContatos();
        System.out.println("\n");
        clienteLucas.imprimirEnderecos();
        System.out.println("\n");
        contaLucas.imprimirContaCorrente();

    }
}
