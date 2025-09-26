package br.com.fiap.resource;

import br.com.fiap.models.Produto;
import br.com.fiap.service.ProdutoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoService produtoService = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        return produtoService.listar();
    }

}
