package dao;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.relatorio.RelatorioQuantidadePedidoPorCliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public Cliente buscarPorId(int id) {
        return em.find(Cliente.class, id);
    }

    public void inserirCliente(Cliente cliente) {
        this.em.persist(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        this.em.merge(cliente);
    }

    public List<Cliente> listarTodas() {
        String queryJPQL = "SELECT cliente FROM Cliente cliente";
        return em.createQuery(queryJPQL, Cliente.class).getResultList();
    }

    public List<Cliente> listarPorNome(String nome) {
        String queryJPQL = "SELECT cliente FROM Cliente cliente WHERE cliente.nome = :nome";
        return em.createQuery(queryJPQL, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<RelatorioQuantidadePedidoPorCliente> getRelatorioPedidoPorCliente() {

        String jpql = "SELECT new br.com.alura.comex.relatorio.RelatorioQuantidadePedidoPorCliente(" +
                "cliente.nome, " +
                "COUNT(pedido.cliente)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.cliente cliente " +
                "GROUP BY cliente.nome ";

        return em.createQuery(jpql, RelatorioQuantidadePedidoPorCliente.class)
                .getResultList();
    }



}
