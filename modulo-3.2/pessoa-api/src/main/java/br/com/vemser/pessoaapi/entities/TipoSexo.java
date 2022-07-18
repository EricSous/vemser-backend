package br.com.vemser.pessoaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TipoSexo {
    M(1, "M"),
    F(2, "F");

    private Integer tipo;
    private String genero;


    public static TipoSexo ofTipo(Integer tipo){
        return Arrays.stream(TipoSexo.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }

    public static TipoSexo ofTipo(String tipo){
        return Arrays.stream(TipoSexo.values())
                .filter(tp -> tp.getGenero().equals(tipo))
                .findFirst()
                .get();
    }
}
