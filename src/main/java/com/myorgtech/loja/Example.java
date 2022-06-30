package com.myorgtech.loja;

import com.myorgtech.loja.dao.CategoriaDao;
import com.myorgtech.loja.dao.ProdutoDao;
import com.myorgtech.loja.modelo.Categoria;
import com.myorgtech.loja.modelo.Produto;
import com.myorgtech.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        Categoria computadores = new Categoria("Computadores");
        Produto notebook = new Produto(
                "Macbook Pro 15", "Macbook 2020 i7", new BigDecimal("25000"), computadores);

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(computadores);
        produtoDao.cadastrar(notebook);
        entityManager.getTransaction().commit();
        List<Produto> todosProdutos = produtoDao.buscarTodos();
        System.out.println(todosProdutos);

        entityManager.close();
    }
}
