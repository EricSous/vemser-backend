package contaCorrente;

public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco(){
        System.out.printf("""
                Tipo: %s
                Logradouro: %s
                Numero: %s
                Complemento: %s
                CEP: %s
                Cidade: %s
                Estado: %s
                Pais: %s
                """,tipo,logradouro,numero,complemento,cep,cidade,estado,pais);
    }
}
