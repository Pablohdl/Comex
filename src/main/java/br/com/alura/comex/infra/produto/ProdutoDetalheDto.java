package br.com.alura.comex.infra.produto;

import br.com.alura.comex.domain.produto.Produto;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class ProdutoDetalheDto {

    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEstoque;
    private Long idCategoria;
    private String nomeCategoria;


    public ProdutoDetalheDto(Produto produto) {
        this.nome = produto.getName();
        this.descricao = produto.getDescricao() ;
        this.precoUnitario = produto.getPrecoUnitario();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.idCategoria = produto.getCategoria().getId();
        this.nomeCategoria = produto.getCategoria().getNome();
    }

    public static Page<ProdutoDetalheDto> converterPagina(Page<Produto> produtos) {
        return produtos.map(ProdutoDetalheDto::new);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
