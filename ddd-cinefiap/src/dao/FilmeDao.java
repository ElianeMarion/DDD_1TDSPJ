package dao;

import enums.ClassificacaoIndicativaEnum;
import enums.GeneroEnum;
import models.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmeDao {
    private Connection conexao;

    public void cadastrarFilme(Filme filme){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into tbl_filme (id_filme, tx_nome, nr_duracao, tp_genero, tp_classificacao, nr_ano, tx_capa, tx_diretor, " +
                    "tx_elenco, tx_descricao, nr_avaliacao) values(?,?,?,?,?,?,?,?,?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, filme.getId());
            comandoSQL.setString(2, filme.getNome());
            comandoSQL.setInt(3, filme.getDuracao());
            comandoSQL.setString(4, filme.getGenero().toString());
            comandoSQL.setString(5, filme.getClassificacao().toString());
            comandoSQL.setInt(6, filme.getAno());
            comandoSQL.setString(7, filme.getCapa());
            comandoSQL.setString(8, filme.getDiretor());
            comandoSQL.setString(9, filme.getElenco());
            comandoSQL.setString(10, filme.getDescricao());
            comandoSQL.setDouble(11, filme.getAvaliacao());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Método que vai no banco e busca por um filme pela chave primária
    public Filme buscarPorId(Long id){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Filme filme = new Filme();
        try {
            ps = conexao.prepareStatement("SELECT * from TBL_FILME " +
                    "WHERE ID_FILME = ?");
            ps.setLong(1, id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                filme.setId(rs.getLong(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setGenero(GeneroEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));

            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filme;
    }
}
