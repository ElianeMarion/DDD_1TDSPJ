package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;
import enums.TipoContatoEnum;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    //Método para alterar uma informação
    public void alterarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE tbl_contato SET nome_contato = ?, celular_contato = ?," +
                    " email_contato = ?, instagram = ?, tipo = ?" +
                    "where id_contato = ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,contato.getNome());
            ps.setString(2, contato.getCelular());
            ps.setString(3, contato.getEmail());
            ps.setString(4, contato.getInstagram());
            ps.setString(5, contato.getTipo().toString());
            ps.setInt(6, contato.getId());
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Método de excluão
    public void excluirContato(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement("delete from " +
                    "tbl_contato where id_contato = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    //Método para buscar um conjunto de contatos (lista)
    //BuscarTodosContatos
    public List<Contato> listar(){
        List<Contato> contatos = new ArrayList<>();
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement("SELECT * FROM TBL_CONTATO order by nome_contato ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(TipoContatoEnum.valueOf(rs.getString(6)));
                contatos.add(contato);
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }

    //Método que exiba todos os contatos por tipo.
    public List<Contato> buscarPorTipo(String tipo){
        List<Contato> contatos = new ArrayList<>();
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement("SELECT * from TBL_CONTATO WHERE TIPO = ?");
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(TipoContatoEnum.valueOf(rs.getString(6)));
                contatos.add(contato);
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }


}
