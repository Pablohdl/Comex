package br.com.alura.comex.model.builder;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.ItemDePedido;
import br.com.alura.comex.model.Produto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoBuilder {

    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEmEstoque;

    private List<ItemDePedido> listaDeItensDePedidos;

    private Categoria categoria;

    public ProdutoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder comPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

    public ProdutoBuilder comQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        return this;
    }

    public ProdutoBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Produto build() {
        return new Produto(nome, descricao, precoUnitario, quantidadeEmEstoque, categoria);
    }
}
