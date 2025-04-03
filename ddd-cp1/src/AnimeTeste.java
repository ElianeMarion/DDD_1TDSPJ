import java.util.Scanner;

public class AnimeTeste {
    public static void main(String[] args) {
        Scanner texto = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);
        Anime a = new Anime();
        System.out.println("Digite o nome do anime: ");
        a.nome = texto.nextLine();
        System.out.println("Digite a classificação indicativa 10, 12, 14, 16, 18, para classificação livre digite 0 ");
        a.classificacaoIndicativa = numeros.nextInt();
        System.out.println("Digite o autor do anime: ");
        a.autor = texto.nextLine();
        System.out.println("Digite o genero do anime: ");
        a.genero = texto.nextLine();
        System.out.println("Digite a quantidade de episódios: ");
        a.qtdEpisodios = numeros.nextInt();
        System.out.println("Digite o numero de temporadas: ");
        a.numeroTemporadas = numeros.nextInt();
        a.exibirDadosAnime();
        System.out.println(a.mensagem);

        System.out.println("=============================");
        Anime meuAnime = new Anime("Boruto",14);
        meuAnime.numeroTemporadas = 3;
        meuAnime.qtdEpisodios = 50;
        meuAnime.exibirDadosAnime();
        System.out.println(meuAnime.mensagem);
        System.out.println("=============================");
        Anime x = new Anime("Naruto Shipuden", 12,512,21);
        x.exibirDadosAnime();
        System.out.println(x.mensagem);
    }
}
