package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;
import br.com.fiap.agenda.models.Endereco;
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
                    " celular_contato, email_contato, instagram, tipo, id_endereco) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getId());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getCelular());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipo().toString());
            comandoSQL.setInt(7,contato.getEndereco().getId());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cadastrarContatoEnderecosEntrega(Contato contato) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            conexao.setAutoCommit(false); // transação

            String sql = "INSERT INTO TBL_CONTATO (ID_CONTATO, nome_contato, " +
                    "celular_contato," +
                    " email_contato, instagram, tipo, id_endereco) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getId());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getCelular());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipo().toString());
            comandoSQL.setInt(7, contato.getEndereco().getId());
            comandoSQL.executeUpdate();
            comandoSQL.close();

            // Inserir endereços de entrega
            if (contato.getEnderecosEntrega() != null) {
                for (Endereco endereco : contato.getEnderecosEntrega()) {
                    PreparedStatement psEntrega = conexao.prepareStatement(
                            "INSERT INTO contato_endereco_entrega " +
                                    "(id_contato, id_endereco)" +
                                    " VALUES (?, ?)");
                    psEntrega.setInt(1, contato.getId());
                    psEntrega.setInt(2, endereco.getId());
                    psEntrega.executeUpdate();
                    psEntrega.close();
                }

            }

            conexao.commit(); // confirma a transação
        } catch (SQLException e) {
            try {
                conexao.rollback(); // desfaz a transação em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null && !conexao.isClosed()) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        EnderecoDao enderecoDao = new EnderecoDao();
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
                int codigo = rs.getInt(7);
                Endereco endereco = new Endereco();
                endereco = enderecoDao.buscarPorId(codigo);
                contato.setEndereco(endereco);
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contato;
    }

    //BuscarPorId atualizado
    public Contato buscarPorIdAtualizado(int id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();
        EnderecoDao enderecoDao = new EnderecoDao();

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
                //Relacionamento endereço x contato (1xN)
                int enderecoPrincipal = rs.getInt(7);
                Endereco endereco = enderecoDao.buscarPorId(enderecoPrincipal);
                contato.setEndereco(endereco);

                // buscar endereços de entrega (N:N)
                PreparedStatement psEntrega = conexao.prepareStatement("" +
                        "SELECT id_endereco FROM contato_endereco_entrega " +
                        "WHERE id_contato = ?");
                psEntrega.setInt(1, id);
                ResultSet rsEntrega = psEntrega.executeQuery();
                List<Endereco> enderecosEntrega = new ArrayList<>();
                while (rsEntrega.next()) {
                    Endereco enderecoEntrega = enderecoDao.buscarPorId(rsEntrega.getInt(1));
                    enderecosEntrega.add(enderecoEntrega);
                }
                contato.setEnderecosEntrega(enderecosEntrega);
                rsEntrega.close();
                psEntrega.close();
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null && !conexao.isClosed()) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
