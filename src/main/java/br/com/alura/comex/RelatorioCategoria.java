package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioCategoria {
	
    Map<String, BigDecimal> montanteCategoria;
    Map<String, Integer> quantidadeProdutosPorCategoria;
   
    
    
    public RelatorioCategoria(List<Pedido> listaDeCategorias) {
    	super();
    	if(listaDeCategorias == null || listaDeCategorias.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
    	this.quantidadeProdutosPorCategoria = new TreeMap<>();
        listaDeCategorias.stream()
                		 .collect(Collectors.groupingBy(Pedido::getCategoria))
                         .forEach((x,y) -> quantidadeProdutosPorCategoria.put(x,y.stream().mapToInt(Pedido::getQuantidade).sum()));
    	this.montanteCategoria = new TreeMap<>();
        listaDeCategorias.stream()
                         .collect(Collectors.groupingBy(Pedido::getCategoria))
                         .forEach((x,y) -> montanteCategoria.put(x, y.stream().map(Pedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add)));
    	}
    
    
	public Map<String, BigDecimal> getMontanteCategoria() {
		return montanteCategoria;
	}



	public Map<String, Integer> getQuantidadeProdutosPorCategoria() {
		return quantidadeProdutosPorCategoria;
	}

	
	
	

}
