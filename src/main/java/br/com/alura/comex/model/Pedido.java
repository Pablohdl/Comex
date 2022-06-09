package br.com.alura.comex.model;

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

    @Enumerated(EnumType.STRING)
    private TipodeDescontoPedido tipoDeDescontoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> listaDePedidos;

    @Deprecated
    public Pedido() {
    }

    public Pedido(LocalDate data, Cliente cliente, List<ItemDePedido> listaDePedidos) {
        this.data = data;
        this.cliente = cliente;
        this.listaDePedidos = listaDePedidos;
    }

    private Pedido(Long id, LocalDate data, Cliente cliente, BigDecimal desconto, TipodeDescontoPedido tipoDeDescontoPedido) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.desconto = desconto;
        this.tipoDeDescontoPedido = tipoDeDescontoPedido;
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
}