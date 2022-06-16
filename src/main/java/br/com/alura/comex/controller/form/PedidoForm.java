package br.com.alura.comex.controller.form;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.TipodeDescontoPedido;
import br.com.alura.comex.repository.ClienteRepository;
import br.com.alura.comex.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Optional;

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
