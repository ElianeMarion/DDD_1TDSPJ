package models;

public class Filme extends Titulo implements Classificavel{
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void somarNotas(double nota) {
        somaAvaliacao += nota;
    }


    @Override
    public int getClassificacao() {
        return (int) somaAvaliacao / totalAvaliacoes;
    }
}
