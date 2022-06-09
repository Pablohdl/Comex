package br.com.alura.comex.main;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.builder.ClienteBuilder;
import br.com.alura.comex.relatorio.RelatorioQuantidadePedidoPorCliente;
import dao.ClienteDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ClienteMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("comexdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        ClienteDAO  cd = new ClienteDAO(entityManager);
        EntityTransaction transaction = entityManager.getTransaction();

       List<RelatorioQuantidadePedidoPorCliente> pedidos = cd.getRelatorioPedidoPorCliente();
        pedidos.forEach(System.out::println);


        buscandoClientePeloNome(entityManagerFactory, entityManager, cd, transaction);
        criandoTresClientes(entityManager);


    }

    private static void criandoTresClientes(EntityManager entityManager) {
        Cliente cliente1 = new ClienteBuilder()
                .comNome("jOAO").comCpf("123456789").comTelefone("345678901")
                .comRua("Av.Caxanga").comBairro("Boa viagem").comNumero("390").comCidade("recife").comComplemento("apt12").comEstado("Pernambuco")
                .comListaDePedidos(new ArrayList<>())
                .build();

        Cliente cliente2 = new ClienteBuilder()
                .comNome("OTAVIO").comCpf("155456789").comTelefone("11232523")
                .comRua("Av.Cosme").comBairro("Carpina").comNumero("142").comCidade("Joao Pessoa").comComplemento("APT13").comEstado("Minas")
                .comListaDePedidos(new ArrayList<>())
                .build();

        Cliente cliente3 = new ClienteBuilder()
                .comNome("Clovis").comCpf("1424536789").comTelefone("1523242523")
               .comRua("Rua Maria").comBairro("Pequena italia").comNumero("S/N").comCidade("Carpina").comComplemento("Casa").comEstado("Acre")
                .comListaDePedidos(new ArrayList<>())
                .build();

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();

        clienteDAO.inserirCliente(cliente1);
        clienteDAO.inserirCliente(cliente2);
        clienteDAO.inserirCliente(cliente3);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void buscandoClientePeloNome(EntityManagerFactory entityManagerFactory, EntityManager entityManager, ClienteDAO cd, EntityTransaction transaction) {
        transaction.begin();

        try {
        List<Cliente> clientes = cd.listarPorNome("Vivian");
        clientes.forEach(System.out::println);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        entityManager.close();
        entityManagerFactory.close();
    }


}
