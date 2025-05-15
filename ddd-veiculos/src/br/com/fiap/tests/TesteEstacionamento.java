package br.com.fiap.tests;

import br.com.fiap.models.BalancoDiario;
import br.com.fiap.models.Segurado;
import br.com.fiap.models.Veiculo;

public class TesteEstacionamento {
    public static void main(String[] args) {
        Segurado veicSeg = new Segurado(10);
        veicSeg.setValorHora(5);
        veicSeg.setValorAdicional(2);
        veicSeg.setHoras(1);
        System.out.println(veicSeg.doViewCupom());

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setHoras(3);
        veiculo2.setValorHora(5);
        veiculo2.setValorAdicional(2);
        System.out.println(veiculo2.doViewCupom());


        BalancoDiario bd = new BalancoDiario();
        bd.doAdd(veicSeg);
        bd.doAdd(veiculo2);
        System.out.println(bd.doGerarRelatorio());
    }
}
