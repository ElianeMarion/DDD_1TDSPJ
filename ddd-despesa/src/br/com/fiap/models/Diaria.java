package br.com.fiap.models;

import java.util.Scanner;

public class Diaria extends Despesa{

    private int qteDiaria;

    public void cadastrarDespesa(){
        super.cadastrarDespesa();
        Scanner leitor = new Scanner(System.in);
        System.out.printf("Quantidade de diárias: ");
        qteDiaria = leitor.nextInt();

    }
    @Override
    public void calcularDespesa() {

        setValorTotal(qteDiaria * 50);
    }

    @Override
    public void listarDespesa() {
        System.out.printf("Relatório de despesa");
        System.out.printf("\n===========================");
        System.out.printf("\nDescrição: " + getDescricao());
        System.out.printf("\nQuantidade de diárias: " + qteDiaria);
        System.out.printf("\nValor total: R$" + getValorTotal());

    }
}

