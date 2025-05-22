import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {
    public static void main(String[] args) {
        List<Integer> quantidadeDigitos = new ArrayList<>();


        List<String> nomes = List.of("Ana", "Bruno", "Carlos");
        //Trazer uma nova lista com a quantidade de digitos de cada nome
        //O método map é usado para transformar os elementos de um stream.
        quantidadeDigitos = nomes.stream()
                .map(nome -> nome.length())
                .collect(Collectors.toList());
        System.out.println(quantidadeDigitos);


        List<List<String>> listaDeListas = List.of(
                List.of("Ana", "Eliane"),
                List.of("Maria", "Jose", "Julio"),
                List.of("Roberto")
        );

        List<String> resultado = listaDeListas.stream()
                .flatMap(lista-> lista.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultado);




    }

}
