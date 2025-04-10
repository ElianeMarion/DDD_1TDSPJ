package br.com.fiap.models;

public class LivroDigital extends Livro{
    private boolean audioLivro;
    public void exibirLivro(){
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + getAutor());
        if(audioLivro)
            System.out.println("É um áudio livro");
    }

    public double aplicarDesconto(double taxa){
        if(getPreco() > 50  && taxa <= 10)
            return getPreco() - getPreco() * taxa / 100;
        return getPreco();

    }
}
