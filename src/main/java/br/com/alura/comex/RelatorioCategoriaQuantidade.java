package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioCategoriaQuantidade {
	
    Map<String, BigDecimal> montanteCategoria;
    Map<String, Integer> quantidadeProdutosPorCategoria;
   
    
    
    public RelatorioCategoriaQuantidade(List<Pedido> listaDeCategorias) {
    	super();
    	if(listaDeCategorias == null || listaDeCategorias.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
		quantidadeDeProdutoPorCategoria(listaDeCategorias);
		montantePorCategoria(listaDeCategorias);
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

	public static void ImprimirRelatorioDeCategorias(RelatorioCategoriaQuantidade category) {
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

	
	
	

}
