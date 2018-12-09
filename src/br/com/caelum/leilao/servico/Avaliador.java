package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

/**
 * @author jribeiro
 * @date 09/12/18
 */
public class Avaliador {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    private double totalLances = 0;

    public void avalia(Leilao leilao) {
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorLance) {
                maiorLance = lance.getValor();
            } if (lance.getValor() < menorLance) {
                menorLance = lance.getValor();
            }
        }
    }

    public double getMaiorLance(){
        return maiorLance;
    }

    public double getMenorLance(){
        return menorLance;
    }

    public double getMediaLances(Leilao leilao) {
        int numeroLances = 0;
        for (Lance lance: leilao.getLances()){
            totalLances = totalLances + lance.getValor();
            numeroLances += 1;
        }
        return totalLances/numeroLances;
    }
}
