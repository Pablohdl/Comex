package br.com.alura.comex.domain.itemDePedido;

import br.com.alura.comex.domain.enun.TipodeDescontoItem;
import br.com.alura.comex.domain.pedido.Pedido;
import br.com.alura.comex.domain.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_de_pedidos")
public class ItemDePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    private TipodeDescontoItem tipoDeDescontoItem;

    public ItemDePedido(){
        super();
    }

    public ItemDePedido(BigDecimal precoUnitario, Integer quantidade, Pedido pedido, Produto produto, BigDecimal desconto, TipodeDescontoItem tipoDeDescontoItem) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
        this.desconto = desconto;
        this.tipoDeDescontoItem = tipoDeDescontoItem;
    }
    public ItemDePedido(BigDecimal precoUnitario, Integer quantidade, Produto produto, BigDecimal desconto, TipodeDescontoItem tipoDeDescontoItem) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.produto = produto;
        this.desconto = desconto;
        this.tipoDeDescontoItem = tipoDeDescontoItem;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Pedido getPedidoId() {
        return pedido;
    }

    public Produto getProdutoId() {
        return produto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipodeDescontoItem getTipoDeDescontoItem() {
        return tipoDeDescontoItem;
    }

    public void setPedido(Pedido pedido) {
    }
    }
