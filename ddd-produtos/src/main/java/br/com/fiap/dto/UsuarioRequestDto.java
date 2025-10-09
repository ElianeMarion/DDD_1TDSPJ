package br.com.fiap.dto;

import br.com.fiap.models.Usuario;
import jakarta.xml.bind.annotation.XmlRootElement;

//Esse Dto será utilizado no cadastro de usuário
@XmlRootElement
public class UsuarioRequestDto {
    private String nome;
    private String login;
    private String senha;

    public UsuarioRequestDto(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public UsuarioRequestDto() {    }

    public Usuario convertToUsuario(UsuarioRequestDto dto){
        Usuario usuario = new Usuario(dto.getNome(), dto.getLogin(), dto.getSenha());
        return usuario;
    }

    public UsuarioRequestDto convertToUsuarioDto(Usuario usuario){
        UsuarioRequestDto dto = new UsuarioRequestDto(usuario.getNome(), usuario.getLogin(), usuario.getSenha());
        return dto;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
