import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author jribeiro
 * @date 09/12/18
 */
public class AvaliadorTest {

    @Test
    public void avaliador(){
        //Avaliador
        Leilao leilao = new Leilao("Carro usado");
        leilao.propoe(new Lance(new Usuario(1,"joão"), 20.000));
        leilao.propoe(new Lance(new Usuario(2,"Maria"), 29.000));
        leilao.propoe(new Lance(new Usuario(3,"Pedro"), 35.000));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double maiorEsperado = 35;
        double menorEsperado = 20;

        Assert.assertEquals(maiorEsperado,avaliador.getMaiorLance(),000000001);
        Assert.assertEquals(menorEsperado,avaliador.getMenorLance(), 000000001);
    }

    @Test
    public void obterMediaLances(){
        //Avaliador
        Leilao leilao = new Leilao("Carro usado");
        leilao.propoe(new Lance(new Usuario(1,"joão"), 20.000));
        leilao.propoe(new Lance(new Usuario(2,"Maria"), 29.000));
        leilao.propoe(new Lance(new Usuario(3,"Pedro"), 35.000));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double mediaEsperada = (20.000 + 29.000 + 35.000)/3;

        Assert.assertEquals(mediaEsperada,avaliador.getMediaLances(leilao),000000001);
    }
}
