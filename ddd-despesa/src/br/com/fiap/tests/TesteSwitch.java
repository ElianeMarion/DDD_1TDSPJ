package br.com.fiap.tests;

public class TesteSwitch {
    public static void main(String[] args) {
        int classificacao = 14;
        switch (classificacao) {
            case 10:
                System.out.println("Não recomendado para menores de 10 anos");
                break;
            case 12:
                System.out.println("Não recomendado para menores de 12 anos");
                break;
            case 14:
                System.out.println("Não recomendado para menores de 10 anos");
                break;
            default:
                System.out.println("idade errada");
                break;

        }

        switch (classificacao){
            case 14 -> System.out.println("14");
            case 16 -> {
                System.out.println("16");
                System.out.println("teste");
            }

        }

    }
}
