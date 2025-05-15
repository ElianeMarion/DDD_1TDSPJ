package br.com.fiap.models;

public class BalancoDiario {
    private static int qtdeCarros;
    private static double total;

    //Polimorfismo -> veiculo (veiculo ou segurado)
    public void doAdd(Veiculo obj){
        qtdeCarros++;
        total += obj.doTotal();
    }

    public String doGerarRelatorio(){
        return "Relatório diário" +
                "\n------------------------------" +
                "\nQuantidade de carros: " + qtdeCarros +
                "\nValor total R$ " + total;
    }
}
