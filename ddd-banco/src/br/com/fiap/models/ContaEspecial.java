package br.com.fiap.models;

import br.com.fiap.enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaEspecial extends ContaComum{
    private double limite;

    public Long abrirConta(int senha, double limite){
        this.limite = limite;
        return super.abrirConta(senha);
    }
    @Override
    public String sacarValor(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return "Saque efetuado com sucesso";
        }
        else if(this.saldo+limite >= valor){
            this.saldo -= valor;
            this.limite += saldo;
            return "Saque efetuado com sucesso utilizando o limite";
        }
        else {
            return "Saque não efetuado, saldo insuficiente";
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
