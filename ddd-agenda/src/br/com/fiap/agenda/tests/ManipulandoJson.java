package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.interfaces.ContatoBD;
import br.com.fiap.agenda.models.Contato;

import java.util.List;

public class ManipulandoJson implements ContatoBD {
    @Override
    public void cadastrar(Contato contato) {

    }

    @Override
    public Contato buscarContato(String nome) {
        return null;
    }

    @Override
    public List<Contato> listar() {
        return null;
    }
}
