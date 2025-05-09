package br.com.fiap.models;

import br.com.fiap.interfaces.Exemplar;

public class Revista implements Exemplar {
    private String nome;
    private String descricao;
    private double preco;
    private Editora editora;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibirLivro() {
        System.out.println("Revista: " + nome);
        System.out.println("Editora: " + editora.getNome());
        System.out.println("Preço: " + preco);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
