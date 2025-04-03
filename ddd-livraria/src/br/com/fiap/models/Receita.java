package br.com.fiap.models;

public class Receita {
    public String nomeReceita;
    public String autorReceita;
    public String dificuldade;
    public int tempoPreparo;
    public int porcoes;
    public String descricao;
    public String ingredientes;
    public String modoPreparo;

    //Método sem retorno
    public void exibirReceita(){
        System.out.println("br.com.fiap.models.Receita de " + nomeReceita);
        System.out.println("===========================");
        System.out.println("Publicado por: " + autorReceita);
        System.out.println("Dificuldade\t\tTempo de preparo\tPorções");
        System.out.println(dificuldade + "\t\t\t\t" + tempoPreparo + "\t\t\t\t" + porcoes);
        System.out.println(descricao);
        System.out.println("Ingredientes\n" + ingredientes);
        System.out.println("Modo de Preparo\n" + modoPreparo);
    }

    //Método com retorno
    public String exibirReceita2(){
        String mensagem = "br.com.fiap.models.Receita de " + nomeReceita +
                "\n===========================" +
                "\nPublicado por: " + autorReceita +
                "\nDificuldade\t\tTempo de preparo\tPorções" +
                "\ndificuldade + \"\\t\\t\\t\\t\" + tempoPreparo + \"\\t\\t\\t\\t\" + porcoes" +
                descricao;
        return mensagem;
    }
}
