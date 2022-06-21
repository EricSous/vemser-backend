package contaCorrente;

public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato(){
        System.out.printf("""
                Dados de Contato do cliente
                Descrição: %s
                Telefone: %s
                Tipo: %s
                """,descricao,telefone,tipo);
    }

}
