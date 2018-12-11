package br.com.caelum.matematica;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jribeiro
 * @date 11/12/18
 */
public class MatematicaMalucaTest {
    @Test
    public void DeveRetornarNumeroMultiplicadoPorQuatroQuandoNumeroMaiorQueTrinta(){
        int numero = 40;
        int numeroEsperao = numero * 4;

        MatematicaMaluca matematicaMaluca =  new MatematicaMaluca();
        Assert.assertEquals(numeroEsperao, matematicaMaluca.contaMaluca(numero));
    }

    @Test
    public void DeveRetornarNumeroMultiplicadoPorTresQuandoNumeroMaiorQueDez(){
        int numero = 11;
        int numeroEsperao = numero * 3;

        MatematicaMaluca matematicaMaluca =  new MatematicaMaluca();
        Assert.assertEquals(numeroEsperao, matematicaMaluca.contaMaluca(numero));
    }

    @Test
    public void DeveRetornarNumeroMultiplicadoPorDois(){
        int numero = 10;
        int numeroEsperao = numero * 2;

        MatematicaMaluca matematicaMaluca =  new MatematicaMaluca();
        Assert.assertEquals(numeroEsperao, matematicaMaluca.contaMaluca(numero));
    }

}
