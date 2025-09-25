package br.com.fiap.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/contatos")
public class ContatoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listar(){
        List<String> nome = new ArrayList<>();
        nome.add("Eliane");
        nome.add("Maria");
        return nome;
    }
}
