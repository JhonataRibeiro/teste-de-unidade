package br.com.caelum.matematica;

/**
 * @author jribeiro
 * @date 11/12/18
 */
public class MatematicaMaluca {
    public int contaMaluca(int numero) {
        if (numero > 30)
            return numero * 4;
        else if (numero > 10)
            return numero * 3;
        else
            return numero * 2;
    }
}
