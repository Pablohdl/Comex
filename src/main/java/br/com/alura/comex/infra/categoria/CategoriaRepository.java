package br.com.alura.comex.infra.categoria;

import br.com.alura.comex.infra.categoria.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);

    @Query(value = "SELECT c.nome AS categoria, SUM(i.quantidade) AS quantidadeProdutos, SUM((i.preco_unitario * i.quantidade)) AS montantePedido " +
            "FROM pedidos " +
            "JOIN itens_de_pedidos i " +
            "JOIN produtos p " +
            "JOIN categorias c " +
            "WHERE pedidos.id = i.pedido_id AND i.produto_id = p.id AND p.categoria_id = c.id " +
            "GROUP BY c.id, pedidos.id, i.id", nativeQuery = true)
    List<RelatorioPedidosPorCategoriaProjection> findPedidosPorCategoria();
}
