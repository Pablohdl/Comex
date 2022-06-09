package main;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;
import br.com.alura.comex.model.builder.CategoriaBuilder;
import dao.CategoriaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CategoriaMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("comexdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        EntityTransaction transaction = entityManager.getTransaction();


        cadastroTresCategorias(entityManager);
        inativandoCategoria(entityManager);

    }

    private static void inativandoCategoria(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        CategoriaDAO cd = new CategoriaDAO(entityManager);
        Categoria categoria4 = cd.buscarPorId(10L);
        categoria4.setStatus(StatusCategoria.INATIVA);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void cadastroTresCategorias(EntityManager entityManager) {
        Categoria categoria1 = new CategoriaBuilder()
                .comNome("PRAIA")
                .comStatus(StatusCategoria.ATIVA)
                .build();

        Categoria categoria2 = new CategoriaBuilder()
                .comNome("CASUAL")
                .comStatus(StatusCategoria.ATIVA)
                .build();

        Categoria categoria3 = new CategoriaBuilder()
                .comNome("ARTES")
                .comStatus(StatusCategoria.ATIVA)
                .build();


        entityManager.getTransaction().begin();
        CategoriaDAO cd = new CategoriaDAO(entityManager);
        Categoria categoria4 = cd.buscarPorId(10L);
        categoria4.setStatus(StatusCategoria.INATIVA);
        cd.inserirCategoria(categoria1);
        cd.inserirCategoria(categoria2);
        cd.inserirCategoria(categoria3);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
