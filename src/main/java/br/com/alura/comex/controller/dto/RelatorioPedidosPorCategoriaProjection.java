package br.com.alura.comex.controller.dto;

import java.math.BigDecimal;

public interface RelatorioPedidosPorCategoriaProjection {

    String getCategoria();
    String getQuantidadeProdutos();
    BigDecimal getMontantePedido();
}
