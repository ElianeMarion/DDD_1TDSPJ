package br.com.fiap.resource;

import br.com.fiap.dto.UsuarioLoginDto;
import br.com.fiap.dto.UsuarioRequestDto;
import br.com.fiap.dto.UsuarioResponseDto;
import br.com.fiap.service.UsuarioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuarios")
public class UsuarioResource {

    private UsuarioService usuarioService = new UsuarioService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(UsuarioRequestDto usuario) {
        try {
            usuarioService.cadastrar(usuario);
            UsuarioResponseDto cadastrado = usuarioService.buscar(usuario.getLogin());
            if (cadastrado.getNome().equals(usuario.getNome())) {
                return Response.status(Response.Status.CREATED).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login (UsuarioLoginDto usuario){
        try {
            String mensagem = usuarioService.autenticarUsuario(usuario);

            if(mensagem.equals("Usuário logado com sucesso")){
                return Response.ok().entity(mensagem).build();
            }
            else if(mensagem.equals( "Usuário e/ou senha inválidos")){
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(mensagem)
                        .build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao autenticar usuário  " + e.getMessage())
                    .build();
        }
        return null;
    }
}
