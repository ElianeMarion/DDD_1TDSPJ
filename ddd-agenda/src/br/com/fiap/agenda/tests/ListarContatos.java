package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;

import java.util.ArrayList;
import java.util.List;

public class ListarContatos {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        ContatoDao dao = new ContatoDao();
        contatos = dao.listar();
        System.out.println("Agenda");
        System.out.println("================================");
        contatos.forEach(System.out::println);
    }
}
