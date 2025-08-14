package br.com.fiap.models;

import br.com.fiap.interfaces.Exemplar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Carrinho {

    private double valorTotal;
    private List<Exemplar> lista = new ArrayList<>();

    public void adicionarItem(Exemplar item){
        System.out.println("Item adicionado: " + item.getNome());
        valorTotal += item.getPreco();
        lista.add(item);
        //if(livro instanceof SubClasse)
    }

    public void imprimirCupom(String path) throws IOException {
        //Caso queira permitir que adicione textos sem apagar o conteúdo existente do arquivo
        //BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.append("    CUPOM FISCAL     \n");
        writer.append("-------------------------------------------\n");
        writer.append("    ITENS COMPRADOS      \n");
        writer.append("-------------------------------------------\n");
        writer.append("Título         -        Preço\n");
        lista.forEach(e -> {
            try {
                writer.append(e.getNome() + " -    " + e.getPreco() + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        writer.append("-------------------------------------------\n");
        writer.append("Valor total da compra R$ " + valorTotal);
        writer.close();
    }


    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
