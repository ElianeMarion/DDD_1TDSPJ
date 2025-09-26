package br.com.fiap.models;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    //Gerar getters e setters


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
