package aula4Praticas;

public class Subtracao implements OperacaoMatematica {
    @Override
    public int calcula(int a, int b) {
        return a - b;
    }
    public int calcula(Double a,Double b,Double c){
        return (int) (a-b-c);
    }
}
