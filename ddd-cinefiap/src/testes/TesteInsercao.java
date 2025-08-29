package testes;

import dao.FilmeDao;
import enums.ClassificacaoIndicativaEnum;
import enums.GeneroEnum;
import models.Filme;

import java.util.Scanner;

public class TesteInsercao {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Filme filme = new Filme(1L, "O Resgate do Amanhã", 120, GeneroEnum.ACAO, ClassificacaoIndicativaEnum.A12, 2023, "capa_resgate_amanha.jpg", "Lucas Pereira",
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
        FilmeDao filmeDao = new FilmeDao();
        filmeDao.cadastrarFilme(filme);
        filmeDao.cadastrarFilme(filme1);
        filmeDao.cadastrarFilme(filme2);

        System.out.printf("Digite o id do filme: ");
        Long id = leitor.nextLong();

        Filme filmeProcurado = new Filme();
        filmeProcurado = filmeDao.buscarPorId(id);
        System.out.println(filmeProcurado);




    }
}
