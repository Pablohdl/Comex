package br.com.alura.comex.domain.pedido;

import br.com.alura.comex.domain.cliente.Cliente;
import br.com.alura.comex.domain.itemDePedido.ItemDePedido;
import br.com.alura.comex.domain.enun.TipodeDescontoPedido;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate data = LocalDate.now();
    @NotNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;

    private BigDecimal desconto;

    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private TipodeDescontoPedido tipoDeDescontoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> listaDePedidos;

    @Deprecated
    public Pedido() {
    }

    public Pedido(LocalDate data, Cliente cliente, BigDecimal desconto, TipodeDescontoPedido tipoDesconto, List<ItemDePedido> listaDePedidos) {
        this.data = data;
        this.cliente = cliente;
        this.desconto = desconto;
        this.tipoDeDescontoPedido = tipoDeDescontoPedido;
        this.listaDePedidos = listaDePedidos;
    }
    public Pedido(LocalDate data, Cliente cliente, List<ItemDePedido> listaDePedidos) {
        this.data = data;
        this.cliente = cliente;
        this.listaDePedidos = listaDePedidos;
    }

    private Pedido(Long id, LocalDate data, Cliente cliente, BigDecimal desconto, BigDecimal valorTotal, TipodeDescontoPedido tipoDeDescontoPedido, List<ItemDePedido> listaDePedidos) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.tipoDeDescontoPedido = tipoDeDescontoPedido;
        this.listaDePedidos = listaDePedidos;
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

    public TipodeDescontoPedido getTipoDeDesconto() {
        return tipoDeDescontoPedido;
    }

    public void setTipoDeDesconto(TipodeDescontoPedido tipoDeDescontoPedido) {
        this.tipoDeDescontoPedido = tipoDeDescontoPedido;
    }

    public List<ItemDePedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(List<ItemDePedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}