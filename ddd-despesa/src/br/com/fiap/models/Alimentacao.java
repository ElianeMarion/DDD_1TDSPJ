package br.com.fiap.models;

import java.util.Scanner;

public class Alimentacao extends Despesa{

    private String nomeRestaurante;
    private int quantidadeRefeicao;


    public void cadastrarDespesa(){
        super.cadastrarDespesa();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Nome do Restaurante: ");
        nomeRestaurante = leitor.nextLine();
        System.out.println("Quantidade de refeições: ");
        quantidadeRefeicao = leitor.nextInt();
    }

    @Override
    public void calcularDespesa() {
        setValorTotal(quantidadeRefeicao * 18);
    }

    @Override
    public void listarDespesa() {
        System.out.println("Relatório de despesa");
        System.out.println("===========================");
        System.out.printf("Descrição: " + getDescricao());
        System.out.println("Nome do restaurante: " + nomeRestaurante);
        System.out.println("Quantidade de refeições: " + quantidadeRefeicao);
        System.out.println("Valor total: R$" + getValorTotal());
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public int getQuantidadeRefeicao() {
        return quantidadeRefeicao;
    }

    public void setQuantidadeRefeicao(int quantidadeRefeicao) {
        this.quantidadeRefeicao = quantidadeRefeicao;
    }


}
