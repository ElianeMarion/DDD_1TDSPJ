package br.com.fiap.agenda.interfaces;

import br.com.fiap.agenda.models.Contato;

import java.util.List;

public interface ContatoBD {
    void cadastrar(Contato contato); //Cadastrar os contatos em um arquivo
    Contato buscarContato(String nome); //Buscar no arquivo nome
    List<Contato> listar(); //Listar todos os contatos

}
