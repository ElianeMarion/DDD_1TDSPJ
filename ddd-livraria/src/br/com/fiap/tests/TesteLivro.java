package br.com.fiap.tests;

import br.com.fiap.enums.TipoCapaEnum;
import br.com.fiap.models.Editora;
import br.com.fiap.models.Livro;

import java.util.Scanner;

public class TesteLivro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        //Criando um objeto do tipo br.com.fiap.models.Editora chamado novatec
        Editora novatec = new Editora();
        novatec.setNome("Novatec");
        novatec.setSite("www.novatec.com");
        novatec.setTelefone("11568958995");

        //Criar um objeto -> Instanciar um objeto
    //  Tipo  nomeObjeto = new Tipo();
        Livro meuLivro = new Livro();
        meuLivro.setTitulo("UML 2");
        meuLivro.setAutor("Gilleanes Guedes");
        meuLivro.setEditora(novatec);
        meuLivro.setPreco(50);
        meuLivro.setPaginas(484);
       // meuLivro.tipoCapa = br.com.fiap.enums.TipoCapaEnum.DURA;
        meuLivro.setResumo("UML abordagem prática....");
        meuLivro.exibirLivro();

        Livro livroDaGiovanna = new Livro(novatec);
        livroDaGiovanna.setTitulo("Harry Potter e a pedra filosofal");
        livroDaGiovanna.setAutor("J K ");

        Livro livro = new Livro();
        System.out.println("Informe o título do livro");
        livro.setTitulo(leitor.nextLine());
        System.out.println("Tipo de capa: \n1 - Comum\n2 - Dura\n3 - Personalizada" +
                "\nEscolha o tipo de capa desejada: ");
        int opcao = leitorNumerico.nextInt();
        if(opcao == 1)
            livro.setTipoCapa(TipoCapaEnum.COMUM);
        else if(opcao == 2)
            livro.setTipoCapa(TipoCapaEnum.DURA);
        else
            livro.setTipoCapa(TipoCapaEnum.PERSONALIZADA);


        Livro livroTeste = new Livro("titulo", "autor", 289,
                novatec, 200,"resumo",TipoCapaEnum.DURA );
    }
}
