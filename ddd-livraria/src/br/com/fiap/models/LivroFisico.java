package br.com.fiap.models;

import br.com.fiap.enums.TipoCapaEnum;

public class LivroFisico extends Livro{
    private String endereco;
    private double taxaEntrega;

    //Sobrescrita de métodos => Método com a mesma assinatura da
    //superclasse porém com regra diferente
    public void exibirLivro(){
        super.exibirLivro();
        System.out.println("Endereço: " + endereco);
        System.out.println("Taxa de entrega: " + taxaEntrega);
    }

    //Construtor é o único método que não é herdado
    public LivroFisico() {
    }

    public LivroFisico(Editora editora) {
        super(editora);
    }

    public LivroFisico(String titulo, String autor, double preco, Editora editora, int paginas, String resumo, TipoCapaEnum tipoCapa) {
        super(titulo, autor, preco, editora, paginas, resumo, tipoCapa);
    }

    public LivroFisico(String titulo, Editora editora, TipoCapaEnum tipoCapa) {
        super(titulo, editora, tipoCapa);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
}
