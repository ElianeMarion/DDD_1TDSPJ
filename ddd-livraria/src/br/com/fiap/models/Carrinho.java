package br.com.fiap.models;

public class Carrinho {

    private double valorTotal;

    public void adicionarItem(Livro livro){
        valorTotal += livro.getPreco();
        //if(livro instanceof SubClasse)
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
