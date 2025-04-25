package br.com.fiap.models;

import java.util.Scanner;

public abstract class Despesa {

    private String descricao;
    private double valorTotal;


    public void cadastrarDespesa(){
        valorTotal = 0;
        Scanner leitor = new Scanner(System.in);
        System.out.printf("Descreva detalhadamente a despesa realizada: ");
        descricao = leitor.nextLine();

    }
    public abstract void calcularDespesa();
    public abstract void listarDespesa();


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
