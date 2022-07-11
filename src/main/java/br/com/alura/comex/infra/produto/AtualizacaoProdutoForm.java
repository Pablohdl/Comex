package br.com.alura.comex.controller.form;

import br.com.alura.comex.domain.produto.Produto;
import br.com.alura.comex.repository.ProdutoRepository;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Optional;

public class AtualizacaoProdutoForm {

    @NotNull
    @NotEmpty
    @Size(min = 2)
    private String nome;
    private String descricao;
    @NotNull
    private BigDecimal precoUnitario;
    private Integer quantidadeEstoque;

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

    public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
      Optional<Produto> produto =  produtoRepository.findById(id);
      produto.get().setName(this.nome);
      produto.get().setDescricao(this.descricao);
      produto.get().setPrecoUnitario(this.precoUnitario);
      produto.get().setQuantidadeEstoque(this.quantidadeEstoque);
      return produto.get();


    }
}
