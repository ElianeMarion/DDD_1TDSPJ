package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;
import enums.TipoContatoEnum;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Toda classe DAO é responsável pelo CRUD
public class ContatoDao {
    private Connection conexao;

    public void cadastrarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "INSERT INTO TBL_CONTATO (ID_CONTATO, nome_contato," +
                    " celular_contato, email_contato, instagram, tipo) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getId());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getCelular());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipo().toString());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Método que vai no banco e busca por um contato pela chave primária
    public Contato buscarPorId(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();
        try {
            ps = conexao.prepareStatement("SELECT * from TBL_CONTATO " +
                    "WHERE ID_CONTATO = ?");
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(TipoContatoEnum.valueOf(rs.getString(6)));
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contato;
    }

}
