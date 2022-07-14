package br.com.alura.comex.infra.itemDePedido;

import br.com.alura.comex.domain.itemDePedido.ItemDePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDePedidoRepository extends JpaRepository<ItemDePedido, Long> {
}
