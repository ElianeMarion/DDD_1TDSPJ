package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;

public class TesteContato {
    public static void main(String[] args) {

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();
        contato.setNome("Maria");
        dao.cadastrarContato(contato);

    }
}
