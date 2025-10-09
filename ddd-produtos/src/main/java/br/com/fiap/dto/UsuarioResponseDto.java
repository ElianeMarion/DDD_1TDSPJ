package br.com.fiap.dto;

import br.com.fiap.models.Usuario;

public class UsuarioResponseDto {
    private String nome;
    private String login;

    public UsuarioResponseDto() {}

    public Usuario convertToUsuario(UsuarioResponseDto dto){
        return new Usuario(dto.nome, dto.login);
    }

    public UsuarioResponseDto convertToUsuarioResponseDto(Usuario usuario){
        return new UsuarioResponseDto(usuario.getNome(), usuario.getLogin());
    }

    public UsuarioResponseDto(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
