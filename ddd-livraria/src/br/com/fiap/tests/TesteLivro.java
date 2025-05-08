package br.com.fiap.tests;

import br.com.fiap.enums.TipoCapaEnum;
import br.com.fiap.models.Editora;
import br.com.fiap.models.Livro;
import br.com.fiap.models.LivroDigital;
import br.com.fiap.models.LivroFisico;

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
        LivroFisico meuLivro = new LivroFisico();
        meuLivro.setTitulo("UML 2");
        meuLivro.setAutor("Gilleanes Guedes");
        meuLivro.setEditora(novatec);
        meuLivro.setPreco(50);
        meuLivro.setPaginas(484);
       // meuLivro.tipoCapa = br.com.fiap.enums.TipoCapaEnum.DURA;
        meuLivro.setResumo("UML abordagem prática....");
        meuLivro.exibirLivro();

        LivroFisico livroDaGiovanna = new LivroFisico(novatec);
        livroDaGiovanna.setTitulo("Harry Potter e a pedra filosofal");
        livroDaGiovanna.setAutor("J K ");

        LivroFisico livro = new LivroFisico();
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


       // LivroDigital livroTeste = new LivroDigital("titulo", "autor", 289,
        //        novatec, 200,"resumo");
    }
}
