package testes;

import dao.FilmeDao;
import enums.ClassificacaoIndicativaEnum;
import enums.GeneroEnum;
import models.Filme;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteInsercao {
    public static void menu(){
        System.out.println("CINE FIAP");
        System.out.println("=======================================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Buscar por ID");
        System.out.println("3 - Listar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("6 - Listar filmes por Gênero");
        System.out.println("7 - Listar filmes por Classificação");
    }

    public static Filme leituraDados(Filme filme){
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Código: ");
        filme.setId(leitorNum.nextLong());
        System.out.println("Nome do filme: ");
        filme.setNome(leitor.nextLine());
        System.out.println("Duração: ");
        filme.setDuracao(leitorNum.nextInt());
        filme.setGenero(menuGenero());
        System.out.println("Classificação indicativa: A10|A12|A14|A16|A18|LIVRE");
        String classif = leitor.next();
        filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(classif));
        System.out.println("Ano: ");
        filme.setAno(leitorNum.nextInt());
        System.out.println("Capa: ");
        filme.setCapa(leitor.nextLine());
        System.out.println("Diretor: ");
        filme.setDiretor(leitor.nextLine());
        System.out.println("Elenco: ");
        filme.setElenco(leitor.nextLine());
        System.out.println("Descrição: ");
        filme.setDescricao(leitor.nextLine());
        System.out.println("Avaliação: ");
        filme.setAvaliacao(leitorNum.nextDouble());
        return filme;
    }

    public static GeneroEnum menuGenero(){
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Genero: " +
                "1 - ACAO\n" +
                "2 - AVENTURA,\n" +
                "3 - COMEDIA,\n" +
                "4 - DRAMA,\n" +
                "5 - FICCAO_CIENTIFICA,\n" +
                "6 - TERROR,\n" +
                "7 - SUSPENSE,\n" +
                "8 - ROMANCE,\n" +
                "9 - FANTASIA,\n" +
                "10 - GUERRA,\n" +
                "11 - FAROESTE,\n" +
                "12 - ANIMACAO,\n" +
                "13 - MUSICAL,\n" +
                "14 - POLICIAL,\n" +
                "15 - DOCUMENTARIO;");
        System.out.println("Digite o número da opção escolhida: ");
       return (GeneroEnum.values()[leitorNum.nextInt() - 1]);
    }
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        FilmeDao filmeDao = new FilmeDao();
        List<Filme> filmes = new ArrayList<>();

        Filme filme = new Filme(1L, "O Resgate do Amanhã", 120, GeneroEnum.ACAO, ClassificacaoIndicativaEnum.A12,
                2023, "capa_resgate_amanha.jpg", "Lucas Pereira",
                "João Silva, Mariana Costa, André Souza",
                "Um grupo de heróis deve impedir uma catástrofe global. Em uma corrida contra o tempo, eles enfrentam desafios imensos e descobrem segredos inesperados sobre o futuro.",
                8.7);
        Filme filme1 = new Filme(
                2L,
                "O Último Guardião",
                135,
                GeneroEnum.FANTASIA,
                ClassificacaoIndicativaEnum.A16,
                2024,
                "capa_guardiao.jpg",
                "Fernanda Lima",
                "Carlos Andrade, Letícia Melo, Vinícius Duarte",
                "Em um mundo mágico à beira da destruição, um jovem guardião deve proteger o último artefato capaz de salvar sua terra, enfrentando inimigos poderosos e lidando com um segredo de seu passado.",
                9.2
        );

        // Criando o segundo filme "No Caminho da Esperança"
        Filme filme2 = new Filme(
                3L,
                "No Caminho da Esperança",
                105,
                GeneroEnum.DRAMA,
                ClassificacaoIndicativaEnum.LIVRE,
                2023,
                "capa_esperanca.jpg",
                "Ricardo Torres",
                "Patrícia Oliveira, Marcos Vinícius, Sofia Costa",
                "Após uma tragédia, uma jovem decide viajar pelo mundo em busca de autoconhecimento e de um novo propósito de vida, tocando a vida de todos ao seu redor.",
                8.4
        );
        int op;
        do {
            menu();
            op = leitorNum.nextInt();
            switch (op) {
                case 1: {
                    System.out.println("CADASTRAR FILME" +
                            "\n===============================================");
                    Filme novoFilme = new Filme();
                    filmeDao.cadastrarFilme(leituraDados(novoFilme));
                    System.out.println("Filme cadastrado com sucesso!");
                }break;
                case 2: {
                    System.out.println("BUSCAR FILME" +
                            "\n===============================================");
                    System.out.printf("Digite o id do filme: ");
                    Long id = leitor.nextLong();

                    Filme filmeProcurado = new Filme();
                    filmeProcurado = filmeDao.buscarPorId(id);
                    System.out.println(filmeProcurado);
                }break;
                case 3: {
                    System.out.println("LISTAR FILMES" +
                            "\n===============================================");
                    filmes = filmeDao.listar();
                    filmes.forEach(System.out::println);
                }break;
                case 4: {
                    System.out.println("ALTERAR FILME" +
                            "\n===============================================");
                    Filme novoFilme = new Filme();
                    filmeDao.alterarFilme(leituraDados(novoFilme));
                    System.out.println("Filme alterado com sucesso!");
                }break;
                case 5: {
                    System.out.println("EXCLUIR FILME" +
                            "\n===============================================");
                    System.out.println("Digite o id do filme a ser excluído: ");
                    int id = leitorNum.nextInt();
                    filmeDao.excluirFilme(id);
                    System.out.println("Filme excluído com sucesso!");
                }break;
                case 6: {
                    System.out.println("LISTAR FILMES POR GENERO" +
                            "\n===============================================");
                    GeneroEnum genero = menuGenero();
                    filmes = filmeDao.listarFilmesPorGenero(genero.name());
                    filmes.forEach(System.out::println);
                }break;
                case 7: {
                    System.out.println("LISTAR FILMES POR CATEGORIA" +
                            "\n===============================================");
                    System.out.println("Classificação indicativa: A10|A12|A14|A16|A18|LIVRE");
                    String classif = leitor.next();
                    ClassificacaoIndicativaEnum classificacao = (ClassificacaoIndicativaEnum.valueOf(classif));
                    filmes = filmeDao.listarFilmesPorCategoria(classificacao.name());
                    filmes.forEach(System.out::println);
                }break;

            }
        }while (op != 0);



    }
}
