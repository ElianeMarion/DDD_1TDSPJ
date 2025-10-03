package br.com.fiap.dto;

import br.com.fiap.models.Produto;

public class ProdutoResponseDto {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoResponseDto convertToDto(Produto produto){
        ProdutoResponseDto dto = new ProdutoResponseDto();
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade());
        return dto;
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
