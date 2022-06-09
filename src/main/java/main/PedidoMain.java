package main;

import br.com.alura.comex.relatorio.RelatorioMontanteCategoria;
import dao.ClienteDAO;
import dao.PedidoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class PedidoMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("comexdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        ClienteDAO cd = new ClienteDAO(entityManager);
        EntityTransaction transaction = entityManager.getTransaction();

        PedidoDAO pd = new PedidoDAO(entityManager);
        List<RelatorioMontanteCategoria> relatorioMontanteCategoria = pd.getRelatorioMontanteCategoria();
        relatorioMontanteCategoria.forEach(System.out::println);






    }





}
