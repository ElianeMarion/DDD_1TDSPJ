package br.com.fiap.models;

public class LivroDigital extends Livro{
    private boolean audioLivro;

    public boolean isAudioLivro() {
        return audioLivro;
    }

    public void setAudioLivro(boolean audioLivro) {
        this.audioLivro = audioLivro;
    }

    public LivroDigital(Editora editora) {
        super(editora);
    }
    public LivroDigital(){
        super();
    }
    public LivroDigital(String titulo, String autor, double preco, Editora editora, int paginas, String resumo) {
        super(titulo, autor, preco, editora, paginas, resumo);
    }

    public LivroDigital(String titulo, Editora editora) {
        super(titulo, editora);
    }


    @Override
    public void exibirDetalhes() {
        if(audioLivro)
            System.out.println("É um áudio livro");
    }

    public double aplicarDesconto(double taxa){
        if(getPreco() > 50  && taxa <= 10)
            return getPreco() - getPreco() * taxa / 100;
        return getPreco();

    }

    @Override
    public String getNome() {
        return titulo;
    }
}
