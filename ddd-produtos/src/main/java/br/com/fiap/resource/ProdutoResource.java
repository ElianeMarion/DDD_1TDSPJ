package br.com.fiap.resource;

import br.com.fiap.models.Produto;
import br.com.fiap.service.ProdutoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoService produtoService = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscarPorId(@PathParam("id") int id){
        return produtoService.buscarPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Produto produto, @Context UriInfo uriInfo){
        produtoService.cadastrar(produto);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(produto.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Produto produto, @PathParam("id") int id){
        Produto produtoBd = produtoService.buscarPorId(id);
        if(produtoBd.getCodigo() == produto.getCodigo()) {
            produtoService.atualizar(produto);
            return Response.ok().build();
        }else{
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") int id){
        produtoService.excluir(id);
    }

}
