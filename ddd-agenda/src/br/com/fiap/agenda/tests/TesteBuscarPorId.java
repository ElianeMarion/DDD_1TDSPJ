package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteBuscarPorId {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o id do contato desejado: ");
        int id = leitor.nextInt();

        contato = dao.buscarPorId(id);
        System.out.println(contato);
    }
}
