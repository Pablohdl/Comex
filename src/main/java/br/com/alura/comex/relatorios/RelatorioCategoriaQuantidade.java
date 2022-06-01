package br.com.alura.comex.relatorios;

import br.com.alura.comex.model.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioCategoriaQuantidade  {
	
    private Map<String, BigDecimal> montanteCategoria;
    private Map<String, Integer> quantidadeProdutosPorCategoria;

	private List<VendasPorCategoria> vendasPorCategoria;
   
    
    
    public RelatorioCategoriaQuantidade(List<Pedido> listaDeCategorias) {
    	super();
		quantidadeDeProdutoPorCategoria(listaDeCategorias);
		montantePorCategoria(listaDeCategorias);
	}


	public List<RelatorioCategoriaQuantidade.VendasPorCategoria> getVendasPorCategoria() {
		return vendasPorCategoria;
	}
	private void montantePorCategoria(List<Pedido> listaDeCategorias) {
		this.montanteCategoria = new TreeMap<>();
		listaDeCategorias.stream()
						 .collect(Collectors.groupingBy(Pedido::getCategoria))
						 .forEach((x,y) -> montanteCategoria.put(x, y.stream().map(Pedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add)));
	}

	private void quantidadeDeProdutoPorCategoria(List<Pedido> listaDeCategorias) {
		this.quantidadeProdutosPorCategoria = new TreeMap<>();
		listaDeCategorias.stream()
						 .collect(Collectors.groupingBy(Pedido::getCategoria))
						 .forEach((x,y) -> quantidadeProdutosPorCategoria.put(x,y.stream().mapToInt(Pedido::getQuantidade).sum()));
	}

	public static void imprimirRelatorioDeCategorias(RelatorioCategoriaQuantidade category) {
		System.out.println("############################");
		System.out.println("#### RELATÓRIO DE CATEGORIAS");
		category.getMontanteCategoria().forEach((x, y) -> System.out.printf("\nNOME: %s \nMontante: %s\nQuantidade Vendida: %s\n", x, y, category.quantidadeProdutosPorCategoria.put(x,null)));
		System.out.println("############################");

    }


	public Map<String, BigDecimal> getMontanteCategoria() {
		return montanteCategoria;
	}



	public Map<String, Integer> getQuantidadeProdutosPorCategoria() {
		return quantidadeProdutosPorCategoria;
	}


	public class VendasPorCategoria {

		private final String categoria;
		private final int quantidadeVendida;

		private final BigDecimal montanteCat;

		public VendasPorCategoria(String categoria, int quantidadeVendida, BigDecimal montanteCat) {
			this.categoria = categoria;
			this.quantidadeVendida = quantidadeVendida;
			this.montanteCat = montanteCat;
		}


		public String getCategoria() {
			return categoria;
		}

		public int getQuantidadeVendida() {
			return quantidadeVendida;
		}

		public BigDecimal getMontanteCat() {
			return montanteCat;
		}
	}
	

}
