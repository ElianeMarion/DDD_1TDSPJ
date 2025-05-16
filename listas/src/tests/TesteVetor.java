package tests;

import java.util.Scanner;

public class TesteVetor {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;
        String[] nomes = new String[5];
        double[] notas = new double[5];

        //para i de 0 até 5 com incremento de 1 a cada volta faça
        for(int i = 0; i < 5; i++){
            System.out.println("Digite o nome do " +(i+1) + " aluno:");
            nomes[i] = leitor.nextLine();
        }

        for(int i = 0; i < 5; i++){
            System.out.println(nomes[i]);
        }
    }
}
