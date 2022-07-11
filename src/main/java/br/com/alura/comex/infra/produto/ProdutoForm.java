package br.com.alura.comex.controller.form;

import br.com.alura.comex.domain.categoria.Categoria;
import br.com.alura.comex.domain.produto.Produto;
import br.com.alura.comex.repository.CategoriaRepository;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoForm {
    @NotNull
    @Size(min = 2)
    private String nome;
    private String descricao;
    @DecimalMin(value = "0.0", inclusive = false)
    @NotNull
    private BigDecimal precoUnitario;
    @NotNull
    private Integer quantidadeEstoque;
    @NotNull
    private Long idCategoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Produto converter(CategoriaRepository categoriaRepository) {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        return new Produto(nome,descricao,precoUnitario,quantidadeEstoque,categoria.get());
    }
}
