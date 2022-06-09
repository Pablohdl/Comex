package dao;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.relatorio.RelatorioMontanteCategoria;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void inserirPedido(Pedido pedido){
        this.em.persist(pedido);
    }

    public List<RelatorioMontanteCategoria> getRelatorioMontanteCategoria() {

        String jpql = "SELECT new br.com.alura.comex.relatorio.RelatorioMontanteCategoria(" +
                "categoria.nome, " +
                "SUM(listaDeItens.quantidade)) " +
                "FROM ItemDePedido listaDeItens " +
                "JOIN listaDeItens.produto produto " +
                "JOIN produto.categoria categoria " +
                "GROUP BY categoria.nome";

        return em.createQuery(jpql, RelatorioMontanteCategoria.class)
                .getResultList();
    }
}
