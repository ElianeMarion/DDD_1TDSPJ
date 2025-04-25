package br.com.fiap.models;

import java.util.Scanner;

public class Transporte extends Despesa{

    private Scanner leitor;
    private double kmPercorrida;
    private double valorPedagios;

    public Transporte(){
        Scanner leitor = new Scanner(System.in);
    }
    public void cadastrarDespesa(){
        super.cadastrarDespesa();
        System.out.printf("KM percorrida: ");
        kmPercorrida = leitor.nextDouble();
        System.out.printf("Pedagios: ");
        valorPedagios = leitor.nextDouble();
    }

    @Override
    public void calcularDespesa() {
        setValorTotal(kmPercorrida * 3 + valorPedagios);
    }

    @Override
    public void listarDespesa() {
        System.out.printf("Relatório de despesa");
        System.out.printf("===========================");
        System.out.printf("Descrição: " + getDescricao());
        System.out.printf("KM percorrida: " + kmPercorrida);
        System.out.printf("Valor de pedágios: " + valorPedagios);
        System.out.printf("Valor total: R$" + getValorTotal());
    }

    public double getKmPercorrida() {
        return kmPercorrida;
    }

    public void setKmPercorrida(double kmPercorrida) {
        this.kmPercorrida = kmPercorrida;
    }

    public double getValorPedagios() {
        return valorPedagios;
    }

    public void setValorPedagios(double valorPedagios) {
        this.valorPedagios = valorPedagios;
    }
}
