package br.com.fiap.tests;

import br.com.fiap.models.Receita;

public class TesteReceita {
    public static void main(String[] args) {
        //Instanciar um objeto = Criar o objeto
        Receita boloFuba = new Receita();
        boloFuba.nomeReceita = "Bolo de fuba";
        boloFuba.autorReceita = "Ana Maria";
        boloFuba.dificuldade = "fácil";
        boloFuba.porcoes = 8;
        boloFuba.tempoPreparo = 35;
        boloFuba.descricao = "O bolo de fubá simples combina com um cafezinho no lanche da tarde. Fácil de preparar, " +
                "a receita leva menos de 10 ingredientes.";
        boloFuba.ingredientes ="1 xícara de chá de óleo\n" +
                "4 ovos\n" +
                "2 xícaras de chá de açúcar\n" +
                "1 xícara de chá de leite morno\n" +
                "2 xícaras de chá de farinha de trigo\n" +
                "1 xícara de chá de fubá\n" +
                "1 colher de sopa de fermento em pó ";
        boloFuba.modoPreparo = "Bata no liquidificador o óleo, ovos e a açúcar até ficar homogêneo. Depois, adicione leite e bata novamente .\n" +
                "2 " +
                "Com o liquidificador batendo, adicione farinha de trigo aos poucos.\n" +
                "3 " +
                "Acrescente o fubá e bata até misturar bem.\n" +
                "4 " +
                "Sem bater, acrescente o fubá e misture com uma espátula.\n" +
                "5 " +
                "Despeje em uma forma untada com manteiga. Leve para assar em forno preaquecido a 250 graus Celsius por 35 minutos.";
        boloFuba.exibirReceita();
        System.out.println(boloFuba.exibirReceita2());



/*
        System.out.println(boloFuba.tempoPreparo + " endereço " + boloFuba);
        br.com.fiap.models.Receita boloFubaEliane = new br.com.fiap.models.Receita();
        boloFubaEliane.tempoPreparo = 50;
        System.out.println(boloFuba.tempoPreparo + " "
                + boloFubaEliane.tempoPreparo +
                " endereço " + boloFubaEliane);
                */

    }
}
