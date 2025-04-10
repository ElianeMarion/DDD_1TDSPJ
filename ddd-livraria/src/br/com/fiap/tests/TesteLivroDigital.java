package br.com.fiap.tests;

import br.com.fiap.models.LivroDigital;

public class TesteLivroDigital {
    public static void main(String[] args) {
        LivroDigital ld = new LivroDigital();
        ld.setPreco(100);
        System.out.println("Preço com desconto R$ " + ld.aplicarDesconto(15));
    }
}
