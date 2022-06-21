package contaCorrente;

public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato(){
        System.out.printf("""
                Descrição: %s
                Telefone: %s
                Tipo: %s
                """,descricao,telefone,tipo);
    }

}
