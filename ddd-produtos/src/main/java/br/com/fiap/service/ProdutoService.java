package br.com.fiap.service;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.models.Produto;

import java.util.List;

public class ProdutoService {
    private ProdutoDao produtoDao = new ProdutoDao();

    public List<Produto> listar(){
        List<Produto> produtos = produtoDao.listar();
        return produtos;
    }

}
