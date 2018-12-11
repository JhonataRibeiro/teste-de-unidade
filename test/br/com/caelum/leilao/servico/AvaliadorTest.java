import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;


/**
 * @author jribeiro
 * @date 09/12/18
 */
public class AvaliadorTest {

    @Test
    public void avaliador() {
        //Avaliador
        Leilao leilao = new Leilao("Carro usado");
        leilao.propoe(new Lance(new Usuario(1, "joão"), 20.000));
        leilao.propoe(new Lance(new Usuario(2, "Maria"), 29.000));
        leilao.propoe(new Lance(new Usuario(3, "Pedro"), 35.000));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double maiorEsperado = 35;
        double menorEsperado = 20;

        assertEquals(maiorEsperado, avaliador.getMaiorLance(), 000000001);
        assertEquals(menorEsperado, avaliador.getMenorLance(), 000000001);
    }

    @Test
    public void obterMediaLances() {
        //Avaliador
        Leilao leilao = new Leilao("Carro usado");
        leilao.propoe(new Lance(new Usuario(1, "joão"), 20.000));
        leilao.propoe(new Lance(new Usuario(2, "Maria"), 29.000));
        leilao.propoe(new Lance(new Usuario(3, "Pedro"), 35.000));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double mediaEsperada = (20.000 + 29.000 + 35.000) / 3;

        assertEquals(mediaEsperada, avaliador.getMediaLances(leilao), 000000001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Leilao leilao = new Leilao("Carro usado 2013");
        leilao.propoe(new Lance(new Usuario(1, "joão"), 200));
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double valorEsperado = 200;

        assertEquals(valorEsperado, avaliador.getMaiorLance(), 000000001);
        assertEquals(valorEsperado, avaliador.getMenorLance(), 000000001);
    }

    @Test
    public void deveRetornarTresMarioresLancesEmOrdemDecrescente() {
        Leilao leilao = new Leilao("Carro usado");

        Usuario joao = new Usuario(1, "João");
        Usuario maria = new Usuario(2, "Maria");
        Usuario pedro = new Usuario(3, "Pedro");

        leilao.propoe(new Lance(joao, 20.000));
        leilao.propoe(new Lance(maria, 29.000));
        leilao.propoe(new Lance(pedro, 35.000));
        leilao.propoe(new Lance(joao, 45.000));
        leilao.propoe(new Lance(maria, 55.000));

        List<Lance> lances = Arrays.asList(
                new Lance(maria, 55.000),
                new Lance(joao, 45.000),
                new Lance(pedro, 35.000)
        );


        Avaliador avaliador = new Avaliador();
        List<Lance> lancesRetornados = avaliador.getMaioresLances(leilao, 3);


        assertEquals(lances.size(), lancesRetornados.size(), 0.00000001);
        assertEquals(55.000, lancesRetornados.get(0).getValor(), 0000001);
        assertEquals(45.000, lancesRetornados.get(1).getValor(), 0000001);
        assertEquals(35.000, lancesRetornados.get(2).getValor(), 0000001);
    }

    @Test
    public void avaliadorDeveFuncionarComLancesRandomicos() {
        Random random = new Random();
        List<Leilao> leilaos = new ArrayList<Leilao>();
        Leilao leilao = new Leilao("Carro usado");

        Usuario joao = new Usuario(1, "João");
        Usuario maria = new Usuario(2, "Maria");
        Usuario pedro = new Usuario(3, "Pedro");

        leilao.propoe(new Lance(joao, 200));
        leilao.propoe(new Lance(maria, 690));
        leilao.propoe(new Lance(pedro, 150));
        leilao.propoe(new Lance(joao, 450));
        leilao.propoe(new Lance(maria, 550));



//        for (int i=0;i < 11; i++){
//            leilao.propoe(new Lance(this.obterUsuarioAleatoriamente(), random.nextInt(200 - 100 ) + 100));
//        }

        Avaliador avaliador = new Avaliador();
//        List<Lance> lancesRetornados = avaliador.getMaioresLances(leilao, 3);
        avaliador.avalia(leilao);
        assertEquals(690, avaliador.getMaiorLance(), 000000001);
        assertEquals(150, avaliador.getMenorLance(), 000000001);
    }

    @Test
    public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {
        List<Leilao> leilaos = new ArrayList<Leilao>();
        Leilao leilao = new Leilao("Carro usado");

        Usuario joao = new Usuario(1, "João");
        Usuario maria = new Usuario(2, "Maria");
        Usuario pedro = new Usuario(3, "Pedro");

        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(maria, 300));
        leilao.propoe(new Lance(pedro, 200));
        leilao.propoe(new Lance(joao, 100));

        Avaliador avaliador = new Avaliador();

        avaliador.avalia(leilao);
        assertEquals(400, avaliador.getMaiorLance(), 000000001);
        assertEquals(100, avaliador.getMenorLance(), 000000001);


    }

    public Usuario obterUsuarioAleatoriamente() {
        Random random = new Random();

        List<Usuario> usuarios = Arrays.asList(
                new Usuario(2, "Maria"),
                new Usuario(1, "João"),
                new Usuario(3, "Pedro")
        );

        return usuarios.get(random.nextInt(2 - 0 ) + 0);
    }



}
