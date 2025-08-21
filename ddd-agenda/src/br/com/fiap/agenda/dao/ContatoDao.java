package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Toda classe DAO é responsável pelo CRUD
public class ContatoDao {
    private Connection conexao;

    public void cadastrarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        /*try{
            String sql = "INSERT INTO TBL_CONTATO (ID_CONTATO, nome_contato, celular_contato, email_contato, instagram, tipo) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?);";

        }catch (SQLException e){
            e.printStackTrace();
        }*/
    }

}
