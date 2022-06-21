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
                """,descricao,telefone);
        if(tipo == 1){
            System.out.println("Tipo: "+ tipo + " Residencial");
        }else {
            System.out.println("Tipo: "+ tipo + " Comercial");
        }
    }

}
