package funcional;

public class Main {

    public static void main(String[] args) {

        Calculo calculo = (a,b) -> a+b;
        System.out.println(calculo.calcular2(5,6));

        Calculo calculo2 = (a,b) -> a*b;
        System.out.println(calculo2.calcular2(5,6));

        
    }
}
