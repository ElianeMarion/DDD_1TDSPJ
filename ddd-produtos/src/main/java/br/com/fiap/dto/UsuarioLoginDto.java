package br.com.fiap.dto;

import br.com.fiap.models.Usuario;

public class UsuarioLoginDto {
    private String login;
    private String senha;

    public UsuarioLoginDto() {}

    public UsuarioLoginDto(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario convertToUsuario(UsuarioLoginDto dto) {

        return new Usuario(dto.login, dto.senha);
    }
}
