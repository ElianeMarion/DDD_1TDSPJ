package br.com.fiap.models;

public class Veiculo {
    private double valorHora;
    private double valorAdicional;
    private double horas;
    public double doTotal(){
        return valorHora + valorAdicional * (horas - 1);
    }
    public String doViewCupom(){
        return "\n\nCupom de estacionamento" +
                "\n-------------------------" +
                "\nQuantidade de horas: " + horas +
                "\nValor primeira hora: " + valorHora +
                "\nValor hora adicional: " +  valorAdicional +
                "\n-------------------------" +
                "\nValor total R$: " + doTotal();
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
}
