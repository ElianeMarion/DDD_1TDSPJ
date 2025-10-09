package br.com.fiap.dao;

import br.com.fiap.models.Usuario;
import br.com.fiap.security.PasswordHash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    /**
     * Cadastrar um usuario
     * Receber um usuário, criptografar a senha e gravar no banco
     * os dados com a senha criptografada
     */
    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO TB_USUARIO (nome, login, senha) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            String senhaCriptografada = PasswordHash.hashPassword(usuario.getSenha());

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, senhaCriptografada);
            ps.executeUpdate();
        }

    }
    public Usuario buscar(String login) throws SQLException {
        String sql = "SELECT * FROM tb_usuario WHERE login = ? ";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                return usuario;
            } else {
                return null;
            }
        }
    }

    public String autenticarUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM tb_usuario WHERE login = ? ";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, usuario.getLogin());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String senhaCriptografada = rs.getString("senha");
                if(PasswordHash.verificarSenha(usuario.getSenha(), senhaCriptografada))
                    return "Usuário logado com sucesso";
                else
                    return "Usuário e/ou senha inválidos";
            }else
                return "Usuário não encontrado.";
        }
    }
}
