package br.com.fiap.models;

public class GerenciadorDespesas {
    private int qtdeAlimentacao;
    private int qtdeTransporte;
    private int qtdeDiaria;
    private double totalAlimentacao;
    private double totalTransporte;
    private double totalDiaria;
    private double totalDespesa;

    public void analisarDespesa(Despesa despesa){
        if(despesa instanceof  Transporte){
            qtdeTransporte++;
            totalTransporte += despesa.getValorTotal();
        }else if(despesa instanceof Diaria){
            qtdeDiaria++;
            totalDiaria += despesa.getValorTotal();
        }else{
            qtdeAlimentacao++;
            totalAlimentacao += despesa.getValorTotal();
        }
        totalDespesa = totalAlimentacao + totalTransporte + totalDiaria;
    }

    public double getTotalDespesa() {
        return totalDespesa;
    }
}
