package br.com.fiap.models;
/*
* cargaHoraria: double
valorHora: double

* */
public class Professor extends Funcionario{
    private double cargaHoraria;
    private double valorHora;

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public void calcularSalario() {
        salario = cargaHoraria * valorHora * 4.5;
    }
}
