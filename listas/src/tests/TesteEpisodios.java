package tests;

import models.ClassificacaoEnum;
import models.Episodio;
import models.Serie;
import models.Temporada;

import java.util.ArrayList;
import java.util.List;

public class TesteEpisodios {
    public static void main(String[] args) {
        Episodio episodio1 = new Episodio(1, "Pilot", 8.5, 1000);
        Episodio episodio2 = new Episodio(2, "Lucifer, Stay. Good Devil", 8.0, 1000);
        Episodio episodio3 = new Episodio(3, "The Would-Be Prince of Darkness", 7.5, 1000);
        Episodio episodio4 = new Episodio(4, "Manly Whatnots", 8.3, 1000);
        Episodio episodio5 = new Episodio(1, "Everything's Coming Up Lucifer", 8.5, 1000);
        Episodio episodio6 = new Episodio(2, "Liar, Liar, Slutty Dress on Fire", 0.0, 1000);
        Episodio episodio7 = new Episodio(3, "Sin-Eater", 7.9, 1000);
        Episodio episodio8 = new Episodio(4, "Lady Parts", 8.3, 1000);

        var temporada1 = new Temporada(1, List.of(episodio1, episodio2, episodio3, episodio4));
        var temporada2 = new Temporada(2,List.of(episodio5, episodio6, episodio7, episodio8));

        List<Temporada> temporadas = new ArrayList<>();
        temporadas.add(temporada1);
        temporadas.add(temporada2);

        Serie lucifer = new Serie("Lucifer", 2016, 50,8.1, 10, ClassificacaoEnum.DEZOITO,
                5,false, 8, 50, temporadas);

/*Exibição da temporada mostrando a lista de episodios com for
        for(var temporada : temporadas ){
            System.out.println("Numero da temporada: " + temporada.getNumeroTemporada());
            System.out.println("-----------------------------------");
            for(var episodio : temporada.getEpisodios()){
                System.out.println("Episodio: " + episodio.getNome());
                System.out.println("Classificação:" + episodio.getClassificacao());
            }
            System.out.println("-----------------------------------");
        }
*/
        temporadas.forEach(System.out::println);
        temporadas.forEach(t -> t.getEpisodios().forEach(e -> System.out.println(e.getNome())));
        temporadas.forEach(t -> {
            System.out.println(t.getNumeroTemporada());
            t.getEpisodios().forEach(e -> System.out.println(e.getNome()));
        });
    }
}
