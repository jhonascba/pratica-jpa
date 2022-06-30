package com.myorgtech.loja.dao;

import com.myorgtech.loja.modelo.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public List<Categoria> buscarTodos() {
        String jpql = "SELECT c from Categoria c";
        return entityManager.createQuery(jpql, Categoria.class).getResultList();
    }
}
