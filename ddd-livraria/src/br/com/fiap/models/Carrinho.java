package br.com.fiap.models;

import br.com.fiap.interfaces.Exemplar;

public class Carrinho {

    private double valorTotal;

    public void adicionarItem(Exemplar item){
        valorTotal += item.getPreco();
        //if(livro instanceof SubClasse)
    }



    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
