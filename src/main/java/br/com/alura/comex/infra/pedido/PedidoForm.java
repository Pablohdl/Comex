package br.com.alura.comex.controller.form;

import br.com.alura.comex.domain.pedido.Pedido;
import br.com.alura.comex.domain.enun.TipodeDescontoPedido;

import java.math.BigDecimal;

public class PedidoForm {

    private BigDecimal valorTotal = BigDecimal.ZERO;

    private Long idCliente;

    private BigDecimal desconto;

    private TipodeDescontoPedido tipoDesconto;

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipodeDescontoPedido getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipodeDescontoPedido tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public Pedido converter() {
        return new Pedido();
    }

}
