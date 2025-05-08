package br.com.fiap.atributoEstatico;

import java.util.Map;

public class Teste {
    public static void main(String[] args) {
        AtributoEstatico estatico = new AtributoEstatico();
        estatico.exibir();

        AtributoEstatico estatico2 = new AtributoEstatico();
        estatico2.exibir();

        AtributoEstatico estatico3 = new AtributoEstatico();
        estatico3.exibir();
        System.out.println(estatico2.quantidade);
        System.out.println(AtributoEstatico.qtdStatic);

        System.out.println("Pi: " + Math.PI);

    }
}
