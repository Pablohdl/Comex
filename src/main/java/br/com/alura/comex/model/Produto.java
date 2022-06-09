package br.com.alura.comex.model;


import javax.persistence.*;
import java.math.BigDecimal;

    @Entity
    @Table(name = "produtos")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String nome;
        private String descricao;

        @Column(name = "preco_unitario", nullable = false)
        private BigDecimal precoUnitario;

        @Column(name = "quantidade_em_estoque", nullable = false)
        private int quantidadeEstoque;

        @ManyToOne(optional = false, cascade = CascadeType.ALL)
        private Categoria categoria;

        public Produto(){
        }

        public Produto(String nome, String descricao, BigDecimal precoUnitario, int quantidadeEstoque, Categoria categoria) {
            this.nome = nome;
            this.descricao = descricao;
            this.precoUnitario = precoUnitario;
            this.quantidadeEstoque = quantidadeEstoque;
            this.categoria = categoria;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
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

        public Categoria getCategoria() {
            return categoria;
        }

        public void setName(String name) {
            this.nome = nome;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public void setPrecoUnitario(BigDecimal precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public void setQuantidadeEstoque(int quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return "Produto{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", descricao='" + descricao + '\'' +
                    ", precoUnitario=" + precoUnitario +
                    ", quantidadeEstoque=" + quantidadeEstoque +
                    ", categoria=" + categoria +
                    '}';
        }
    }
