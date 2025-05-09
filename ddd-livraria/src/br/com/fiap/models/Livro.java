package br.com.fiap.models;


import br.com.fiap.enums.TipoCapaEnum;
import br.com.fiap.interfaces.Exemplar;

import java.time.LocalDateTime;
import java.util.Random;

public abstract class Livro implements Exemplar {
    //Atributo tipo nomeAtributo;
    protected String titulo;
    private String autor;
    private  double preco;
    private Editora editora;
    private int paginas;
    private String resumo;


    //+ aplicarDesconto(taxa: double): double
    public double aplicarDesconto(double taxa){
        if(preco > 50)
            return preco - preco * taxa / 100;
        return preco;
    }

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }


    //Construtor
    //Sobrecarga de métodos -> Métodos com mesmo nome porém assinatura diferente


    public Livro(Editora editora){
        this.editora = editora;
    }

    public Livro(String titulo, String autor, double preco,
                 Editora editora, int paginas, String resumo
                 ) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.editora = editora;
        this.paginas = paginas;
        this.resumo = resumo;

    }

    public Livro(String titulo, Editora editora) {
        this.titulo = titulo;
        this.editora = editora;

    }

    //Método para exibir o livro
    public void exibirLivro(){
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora.getNome());
        System.out.println("Preço: " + preco);
        exibirDetalhes();
        System.out.println("-------------------------------------\n");
    }
    public abstract void exibirDetalhes();
    public String exibirTipoCapa(){
        return "";
    }

    public boolean ehMaisCaroQue(Livro outroLivro){
        return preco > outroLivro.preco;
    }
}
