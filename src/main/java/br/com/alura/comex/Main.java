package br.com.alura.comex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("comexdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



    }

    }


