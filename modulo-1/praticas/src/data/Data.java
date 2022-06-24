package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static String dataCincoAnosAntes() {
        Date data = new Date();
        SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
        String anoMenosCinco = String.valueOf(Integer.parseInt(sdfAno.format(data)) - 5);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/");
        return sdf.format(data)+anoMenosCinco;
    }


    public static void main(String[] args) {
        System.out.println(dataCincoAnosAntes());


    }
}
