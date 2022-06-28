package br.com.alura.comex.repository;

import br.com.alura.comex.controller.dto.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
