package br.com.alura.comex.infra.pedido;

import br.com.alura.comex.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
