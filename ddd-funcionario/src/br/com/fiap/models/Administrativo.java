package br.com.fiap.models;

public class Administrativo extends Funcionario{
    private int jornada;
    private int quantidadeSalariosMinimos;
    private String cargo;

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    @Override
    public void calcularSalario() {
        if(jornada == 40)
            salario = quantidadeSalariosMinimos * 1200 * 4.5;
        else
            salario = (quantidadeSalariosMinimos * 1200 * 4.5)/2;

    }
}
