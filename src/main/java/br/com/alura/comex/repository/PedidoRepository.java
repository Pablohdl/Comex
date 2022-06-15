package br.com.alura.comex.repository;

import br.com.alura.comex.controller.dto.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT c.nome AS categoria, SUM(i.quantidade) AS quantidadeProdutos, SUM(pedidos.valor_total) AS montantePedido " +
            "FROM pedidos " +
            "JOIN itens_de_pedidos i " +
            "JOIN produtos p " +
            "JOIN categorias c " +
            "WHERE pedidos.id = i.pedido_id AND i.produto_id = p.id AND p.categoria_id = c.id " +
            "GROUP BY c.id, pedidos.id, i.id", nativeQuery = true)
    List<RelatorioPedidosPorCategoriaProjection> findPedidosPorCategoria();
}
