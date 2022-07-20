package br.com.vemser.pessoaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoPet {

    CACHORRO(1),
    GATO(2),
    GUAXINIM(3);

    private Integer tipo;



    public static TipoSexo ofTipo(Integer tipo) {
        return Arrays.stream(TipoSexo.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
