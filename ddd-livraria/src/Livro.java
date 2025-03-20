public class Livro {
    //Atributo tipo nomeAtributo;
    String titulo;
    String autor;
    double preco;
    Editora editora;
    int paginas;
    String resumo;
    TipoCapaEnum tipoCapa; //COMUM, DURA, PERSONALIZADA

    //Método para exibir o livro
    public void exibirLivro(){
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora.nome);
        System.out.println("Preço: " + preco);
        System.out.println("Tipo de capa: " + tipoCapa);
        System.out.println("-------------------------------------\n");
    }

    public String exibirTipoCapa(){
        return "";

    }
}
