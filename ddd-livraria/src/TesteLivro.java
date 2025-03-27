import java.util.Scanner;

public class TesteLivro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        //Criando um objeto do tipo Editora chamado novatec
        Editora novatec = new Editora();
        novatec.nome = "Novatec";
        novatec.site = "www.novatec.com";
        novatec.telefone = "11568958995";

        //Criar um objeto -> Instanciar um objeto
    //  Tipo  nomeObjeto = new Tipo();
        Livro meuLivro = new Livro();
        meuLivro.titulo = "UML 2";
        meuLivro.autor = "Gilleanes Guedes";
        meuLivro.editora = novatec;
        meuLivro.preco = 50;
        meuLivro.paginas = 484;
       // meuLivro.tipoCapa = TipoCapaEnum.DURA;
        meuLivro.resumo = "UML abordagem prática....";
        meuLivro.exibirLivro();

        Livro livroDaGiovanna = new Livro(novatec);
        livroDaGiovanna.titulo = "Harry Potter e a pedra filosofal";
        livroDaGiovanna.autor = "J K ";

        Livro livro = new Livro();
        System.out.println("Informe o título do livro");
        livro.titulo = leitor.nextLine();
        System.out.println("Tipo de capa: \n1 - Comum\n2 - Dura\n3 - Personalizada" +
                "\nEscolha o tipo de capa desejada: ");
        int opcao = leitorNumerico.nextInt();
        if(opcao == 1)
            livro.tipoCapa = TipoCapaEnum.COMUM;
        else if(opcao == 2)
            livro.tipoCapa = TipoCapaEnum.DURA;
        else
            livro.tipoCapa = TipoCapaEnum.PERSONALIZADA;


        Livro livroTeste = new Livro("titulo", "autor", 289,
                novatec, 200,"resumo",TipoCapaEnum.DURA );
    }
}
