package br.com.alura.comex.infra.categoria;

import java.math.BigDecimal;

public interface RelatorioPedidosPorCategoriaProjection {

    String getCategoria();
    String getQuantidadeProdutos();
    BigDecimal getMontantePedido();
}
