package br.com.alura.comex.controller.dto;

import br.com.alura.comex.domain.cliente.Cliente;
import br.com.alura.comex.domain.itemDePedido.ItemDePedido;
import br.com.alura.comex.domain.pedido.Pedido;
import br.com.alura.comex.domain.enun.TipodeDescontoPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PedidoDto {

    private Long id;
    private LocalDate data = LocalDate.now();
    private Cliente cliente;
    private BigDecimal desconto;
    private TipodeDescontoPedido tipoDeDescontoPedido;
    private List<ItemDePedido> listaDePedidos;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.desconto = pedido.getDesconto();
        this.tipoDeDescontoPedido = pedido.getTipoDeDesconto();
        this.listaDePedidos = pedido.getListaDePedidos();
    }

    public static List<PedidoDto> converterOp(Optional<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }

    public static List<PedidoDto> converter(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipodeDescontoPedido getTipoDeDescontoPedido() {
        return tipoDeDescontoPedido;
    }

    public void setTipoDeDescontoPedido(TipodeDescontoPedido tipoDeDescontoPedido) {
        this.tipoDeDescontoPedido = tipoDeDescontoPedido;
    }

    public List<ItemDePedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(List<ItemDePedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }
}
