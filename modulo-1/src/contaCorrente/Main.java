package contaCorrente;

public class Main {
    public static void main(String[] args) {
        Cliente clienteJoao = new Cliente();
        clienteJoao.cpf = "870.227.650-06";
        clienteJoao.nome = "João da silva";
        Contato contatoJoao = new Contato();
        contatoJoao.telefone = "61 99140-5346";
        contatoJoao.tipo = 1;
        contatoJoao.descricao = "Telefone do cliente";
        clienteJoao.contato = contatoJoao;

        Endereco enderecoJoao = new Endereco();
        enderecoJoao.cep = "72322-578";
        enderecoJoao.cidade = "Brasilia";
        enderecoJoao.complemento = "Em frente ao hospital reginal";
        enderecoJoao.estado = "Distrito Federal";
        enderecoJoao.logradouro = "QR";
        enderecoJoao.numero = 105;
        enderecoJoao.pais = "Brasil";
        enderecoJoao.tipo = 1;

        clienteJoao.endereco = enderecoJoao;


        Cliente clienteLucas = new Cliente();
        clienteLucas.cpf = "005.224.660-44";
        clienteLucas.nome = "Lucas santos";
        Contato contatoLucas = new Contato();
        contatoLucas.telefone = "61 3598-6314";
        contatoLucas.tipo = 2;
        contatoLucas.descricao = "Telefone da casa do cliente";
        clienteLucas.contato = contatoLucas;

        Endereco enderecoLucas = new Endereco();
        enderecoLucas.cep = "71922-428";
        enderecoLucas.cidade = "salvador";
        enderecoLucas.complemento = "Em frente a igreja";
        enderecoLucas.estado = "Bahia";
        enderecoLucas.logradouro = "São joao";
        enderecoLucas.numero = 95;
        enderecoLucas.pais = "Brasil";
        enderecoLucas.tipo = 2;

        clienteLucas.endereco = enderecoLucas;
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

        contaJoao.depositar(500.0);
        System.out.println(contaJoao.saldo);
        contaJoao.sacar(600.0);
        System.out.println(contaJoao.saldo);
        contaJoao.sacar(200.0);
        System.out.println(contaJoao.saldo);

        contaLucas.depositar(1500.0);
        contaLucas.transferir(contaJoao,300.0);
        System.out.println("Saldo novo do João: " + contaJoao.saldo);
        System.out.println("Saldo novo do Lucas: " + contaLucas.saldo);

        clienteJoao.imprimirClientes();
        clienteJoao.imprimirContatos();
        clienteJoao.imprimirEnderecos();
        clienteLucas.imprimirClientes();
        clienteLucas.imprimirContatos();
        clienteLucas.imprimirEnderecos();

    }
}
