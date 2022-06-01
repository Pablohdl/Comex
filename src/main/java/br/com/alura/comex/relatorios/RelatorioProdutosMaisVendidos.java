package br.com.alura.comex.relatorios;

import br.com.alura.comex.model.Pedido;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioProdutosMaisVendidos  {


	private Map<String, Integer> quantidadeProdutosPorVendas;

	private List<ProdutosMaisVendidos> produtosMaisVendidos;



	public RelatorioProdutosMaisVendidos(List<Pedido> listaDeProdVendas ) {
		super();
		exibir(listaDeProdVendas);
		pegarQuantidadeDeProdutosPorVendas(listaDeProdVendas);

	}

	public void exibir(List<Pedido> listaDeProdVendas) {
		if (listaDeProdVendas == null || listaDeProdVendas.isEmpty())
			throw new IllegalArgumentException("A lista esta vazia.");
	}

	public List<RelatorioProdutosMaisVendidos.ProdutosMaisVendidos> getProdutosMaisVendidos() {
		return produtosMaisVendidos;
	}

	private void pegarQuantidadeDeProdutosPorVendas(List<Pedido> listaDeProdVendas) {
		this.quantidadeProdutosPorVendas = new TreeMap<>();
		listaDeProdVendas.stream()
				.collect(Collectors.groupingBy(Pedido::getProduto))
				.forEach((x, y) -> quantidadeProdutosPorVendas.put(x, y.stream().mapToInt(Pedido::getQuantidade).sum()));
	}

	public static void imprimirRelatorioDeProdutosMaisVendidos(RelatorioProdutosMaisVendidos prod) {
		System.out.println("####RELATORIO PRODUTO MAIS VENDIDO");
		prod.getQuantidadeProdutosPorVendas()
				.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.limit(3)
				.forEach(x -> System.out.printf("\nPRODUTO: %s\nQUANTIDADE: %s\n", x.getKey(), x.getValue()));
		System.out.println("############################");
	}


	public Map<String, Integer> getQuantidadeProdutosPorVendas() {
		return quantidadeProdutosPorVendas;
	}


		public class ProdutosMaisVendidos {

		private final String produto;
		private final int quantidadeVendida;

		public ProdutosMaisVendidos(String produto, int quantidadeVendida) {
			this.produto = produto;
			this.quantidadeVendida = quantidadeVendida;
		}


			public String getProduto() {
				return produto;
			}

			public int getQuantidadeVendida() {
				return quantidadeVendida;
			}

	}
}
