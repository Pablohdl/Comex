package br.com.alura.comex.model.builder;

import br.com.alura.comex.model.ItemDePedido;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.model.TipodeDescontoItem;

import java.math.BigDecimal;

public class ItemDePedidoBuilder {

    private BigDecimal precoUnitario;

    private Integer quantidade;

    private Pedido pedido;

    private Produto produto;

    private BigDecimal desconto;

    private TipodeDescontoItem tipoDesconto;

    public ItemDePedidoBuilder comPrecoUnitario(BigDecimal preco) {
        this.precoUnitario = preco;
        return this;
    }

    public ItemDePedidoBuilder comQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemDePedidoBuilder comPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public ItemDePedidoBuilder comProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public ItemDePedidoBuilder comDesconto(BigDecimal desconto) {
        this.desconto = desconto;
        return this;
    }

    public ItemDePedidoBuilder comTipoDescontoItem(TipodeDescontoItem tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
        return this;
    }

    public ItemDePedido build() {
        return new ItemDePedido(precoUnitario,quantidade, pedido, produto, desconto, tipoDesconto);
    }

}
