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
                
                Dados de Endereço do cliente
                Logradouro: %s
                Numero: %s
                Complemento: %s
                CEP: %s
                Cidade: %s
                Estado: %s
                Pais: %s
                """, logradouro, numero, complemento, cep, cidade, estado, pais);
        if(tipo == 1){
            System.out.println("Tipo: "+ tipo + " Residencial");
        }else {
            System.out.println("Tipo: "+ tipo + " Comercial");
        }
    }
}
