package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.models.Endereco;
import br.com.fiap.agenda.services.ViaCepService;

import java.util.Scanner;

public class TesteInsercaoComBuscaViaCep {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Scanner ent = new Scanner(System.in);
        ViaCepService consulta = new ViaCepService();
        Endereco meuEndereco = new Endereco();
        System.out.println("Digite o número do CEP para consulta: ");
        var cep = leitor.nextLine();
        try {
            meuEndereco = consulta.buscaEndereco(cep);
            System.out.println("Digite o código do endereco: ");
            meuEndereco.setId(ent.nextInt());
            meuEndereco.setCep(cep);
            System.out.println(meuEndereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }


}
