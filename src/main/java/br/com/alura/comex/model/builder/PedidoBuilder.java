package br.com.alura.comex.model.builder;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.ItemDePedido;
import br.com.alura.comex.model.Pedido;

import java.time.LocalDate;
import java.util.List;

public class PedidoBuilder {

    private LocalDate data;

    private Cliente cliente;

    private List<ItemDePedido> listaDePedidos;

    public PedidoBuilder comData(LocalDate data) {
        this.data = data;
        return this;
    }

    public PedidoBuilder comCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder comListaDePedidos(List<ItemDePedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
        return this;
    }

    public Pedido build() {
        return new Pedido(data, cliente, listaDePedidos);
    }
}
