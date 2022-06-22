package br.com.alura.comex.model.builder;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.ItemDePedido;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.TipodeDescontoPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoBuilder {
    private LocalDate data;

    private Cliente cliente;

    private BigDecimal desconto;

    private TipodeDescontoPedido tipoDesconto;

    private List<ItemDePedido> listaDePedidos;

    public PedidoBuilder comData(LocalDate data) {
        this.data = data;
        return this;
    }

    public PedidoBuilder comDataAtual() {
        this.data = LocalDate.now();
        return this;
    }

    public PedidoBuilder comCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder comDesconto(BigDecimal desconto) {
        this.desconto = desconto;
        return this;
    }

    public PedidoBuilder comTipoDesconto(TipodeDescontoPedido tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
        return this;
    }

    public PedidoBuilder comListaDePedidos(List<ItemDePedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
        return this;
    }

    public PedidoBuilder aplicarDesconto() {

        this.tipoDesconto = TipodeDescontoPedido.NENHUM;
        this.desconto = BigDecimal.ZERO;

        if (cliente.getListaDePedidos() == null) return this;

        if (cliente.getListaDePedidos().size() > 5) {
            this.tipoDesconto = TipodeDescontoPedido.FIDELIDADE;
            this.desconto = new BigDecimal(0.5);
        }

        return this;
    }

    public Pedido build() {
        return new Pedido(data, cliente, desconto, tipoDesconto, listaDePedidos);
    }
}
