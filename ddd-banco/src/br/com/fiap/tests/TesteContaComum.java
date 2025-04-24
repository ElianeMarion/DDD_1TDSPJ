package br.com.fiap.tests;

import br.com.fiap.models.ContaComum;
import br.com.fiap.models.ContaEspecial;

public class TesteContaComum {
    public static void main(String[] args) {
        ContaComum conta = new ContaComum();
        conta.abrirConta(1234);

        ContaEspecial contaEspecial = new ContaEspecial();
    }
}
