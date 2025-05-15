package listas;

import java.util.ArrayList;

public class ExemploArrayList {
    public static void exibirListaFor(ArrayList<String> nomes){
        System.out.println("\nLista de nomes" +
                "\n-----------------------------------");
        //size() => devolve o tamanho da lista
        for(int i = 0; i < nomes.size(); i++){
            //get() -> retorna um elemento da lista de acordo com o índice
            System.out.println(nomes.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        //Adicionando elementos na lista
        nomes.add("Eliane");
        nomes.add("Maria");
        nomes.add("Felipe");
        nomes.add("Andre");
        exibirListaFor(nomes);
        nomes.add(2,"Ana");
        exibirListaFor(nomes);

        System.out.println("Primeiro nome da lista: " + nomes.get(0));
        System.out.println("Tamanho da lista: " + nomes.size());
        nomes.remove(1);
        exibirListaFor(nomes);

        System.out.println("\nClonar uma lista");
        ArrayList<String> nomesAlunos = new ArrayList<>();
        nomesAlunos = (ArrayList<String>) nomes.clone();
        exibirListaFor(nomesAlunos);

        //Verificar se existe um elemento na lista
        if(nomes.contains("Jose")){
            System.out.println("Existe na lista");
        }else{
            System.out.println("Não existe na lista");
        }

        //Ordenar uma lista
        System.out.println("Ordenação da lista nomeAlunos");
        nomesAlunos.sort(null);
        exibirListaFor(nomesAlunos);

        System.out.println("Lista com foreach");
        //Exibir listas com foreach
        //Para cada nome da lista nomes faça
        for(String nome : nomes){
            System.out.println(nome);
        }

    }
}
