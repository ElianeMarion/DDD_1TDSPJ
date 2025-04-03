package br.com.fiap.models;

public class Editora {
    private String nome;
    public String site;
    public String telefone;

    /*
    * Construtor -> descrever como o objeto será criado
    * Deve ter obrigatoriamente o nome da classe
    * Não tem retorno
    * No momento em que eu crio um construtor o padrão deixa de existir
    * */

    public Editora(String nome){
        this.nome = nome;
    }
    public Editora(){}
    public void exibirEditora(){
        System.out.println("br.com.fiap.models.Editora " + nome);
        System.out.println("Site: " + site);
        System.out.println("Telefone: " + telefone);
    }
}
