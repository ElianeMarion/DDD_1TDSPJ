package br.com.fiap.atributoEstatico;

public class AtributoEstatico {
    public int quantidade;
    public static int qtdStatic;

    public AtributoEstatico(){
        quantidade++;
        qtdStatic++;
    }
    public void exibir(){
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Quantidade estatico: " + qtdStatic);
    }
}
