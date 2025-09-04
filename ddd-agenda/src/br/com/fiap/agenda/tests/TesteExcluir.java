package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteExcluir {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o id do contato: ");
        int id = leitor.nextInt();
        dao.excluirContato(id);
        System.out.println("Registro excluído com sucesso!");
    }
}
