package br.com.fiap.models;

import br.com.fiap.enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaComum {
    protected Long nroConta;
    protected LocalDate dtAbertura;
    protected LocalDate dtEncerramento;
    protected SituacaoEnum situacao;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;

    /*Método abrirConta: A função deste método é abrir uma nova conta, este método agirá
    como um método construtor, recebendo como parâmetro somente a senha da conta, a
    ser definida pelo cliente, o número da conta será gerado automaticamente e retornado
    pelo método. A data de abertura é tomada do sistema considere o código: dtAbertura =
    LocalDate.now(), a data de encerramento deverá ser deixada em branco e a situação
    definida como ATIVA e o saldo inicial receberá 100.

    + abrirConta(senha: int): Long
    * */

    public Long abrirConta(int senha){
        Random random = new Random();
        this.nroConta = random.nextLong(1000);
        this.senha = senha;
        this.situacao = SituacaoEnum.ATIVA;
        this.dtAbertura = LocalDate.now();
        this.saldo = 100;
        return nroConta;
    }

    public boolean validarSenha(int senha){
        if(this.senha == senha)
            return true;
        else
            return false;
    }
    public String sacarValor(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return "Saque efetuado com sucesso";
        }
        else {
            return "Saque não efetuado, saldo insuficiente";
        }
    }
    public void depositarValor(double valor, Long nroConta){
        if(nroConta == this.nroConta){
            this.saldo += valor;
        }
    }
    public String encerrarConta(Long nroConta){
        if(nroConta == this.nroConta){
            this.saldo = 0;
            this.situacao = SituacaoEnum.INATIVA;
            return "Conta encerrada";
        }
        else
            return "Conta inválida";
    }


}
