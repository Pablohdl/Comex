package br.com.alura.comex.relatorios;

import br.com.alura.comex.model.Pedido;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioProdutoMaisCaroCategoria {


    private Map<String, String> produtoMaisCaroCategoria;

    private Map<String, BigDecimal> maiorPrecoPorCategoria;

    private List<ProdutosMaisCarosCatego> produtosMaisCarosCatego;


    public List<RelatorioProdutoMaisCaroCategoria.ProdutosMaisCarosCatego> getProdutosMaisCarosCatego() {
        return produtosMaisCarosCatego;
    }

    public RelatorioProdutoMaisCaroCategoria(List<Pedido> listaDeProdutosMaisCaros) {

        this.produtoMaisCaroCategoria = new TreeMap<>();
        listaDeProdutosMaisCaros.stream().collect(Collectors.groupingBy(Pedido::getCategoria)).forEach((a, b) -> {
            produtoMaisCaroCategoria.put(a, b.stream().max(Comparator.comparing(Pedido::getPreco))
                    .orElseThrow(() -> new IllegalStateException("Não foi possível encontrar o produto mais caro da Categoria: " + a)).getProduto());
        });


        this.maiorPrecoPorCategoria = new TreeMap<>();
        listaDeProdutosMaisCaros.stream().collect(Collectors.groupingBy(Pedido::getCategoria)).forEach((a, b) -> {
            maiorPrecoPorCategoria.put(a, b.stream().max(Comparator.comparing(Pedido::getPreco))
                    .orElseThrow(() -> new IllegalStateException("Não foi possível encontrar o maior valor Categoria: " + a)).getPreco());
        });
    }

    public Map<String, String> getProdutoMaisCaroCategoria() {
        return produtoMaisCaroCategoria;
    }

    public Map<String, BigDecimal> getMaiorPrecoPorCategoria() {
        return maiorPrecoPorCategoria;
    }

    public static void imprimirRelatorioDeProdutosMaisCaroCategoria(RelatorioProdutoMaisCaroCategoria prodcaro) {
        System.out.println("####RELATORIO PRODUTO MAIS VENDIDO");
        prodcaro.getMaiorPrecoPorCategoria()
                .entrySet().stream()
                .forEach(x -> System.out.printf("\nCATEGORIA: %s\nMONTANTE: %s\n PRODUTO: %s\n", x.getKey(), x.getValue(), prodcaro.produtoMaisCaroCategoria.put(x.getKey(), null)));
    }

    public class ProdutosMaisCarosCatego {

        private final String categoria;
        private final String produto;
        private final BigDecimal preco;

        public ProdutosMaisCarosCatego(String categoria, String produto, BigDecimal preco) {
            this.categoria = categoria;
            this.produto = produto;
            this.preco = preco;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getProduto() {
            return produto;
        }

        public BigDecimal getPreco() {
            return preco;
        }

    }
}

