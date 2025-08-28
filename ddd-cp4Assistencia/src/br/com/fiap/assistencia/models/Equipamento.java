package br.com.fiap.assistencia.models;

import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private String numeroSerie;
    private String modelo;
    private List<Servico> servicos;

    public Equipamento(String numeroSerie, String modelo) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico s){
        servicos.add(s);
    }

    @Override
    public String toString() {
        String mensagem = "Equipamento:" +
                "numeroSerie: " + numeroSerie +
                ", modelo: " + modelo +
                ", servicos:" ;
        for(Servico s : servicos){
            mensagem += s.getDescricao() + " - " + s.getValor();
        }
        return  mensagem;

    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public List<Servico> getServicos() {
        return servicos;
    }
}
