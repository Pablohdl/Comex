package br.com.alura.comex;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioProdutos {
	
	
	
	 Map<String, Integer> quantidadeProdutosPorVendas;
	
	
	
	
	public RelatorioProdutos(List<Pedido> listaDeProdVendas) {
	 super();
	 this.quantidadeProdutosPorVendas = new TreeMap<>();
     listaDeProdVendas.stream()
             		 .collect(Collectors.groupingBy(Pedido::getProduto))
                      .forEach((x,y) -> quantidadeProdutosPorVendas.put(x,y.stream().mapToInt(Pedido::getQuantidade).sum()));

	 }
	
	public Map<String, Integer> getQuantidadeProdutosPorVendas() {
		return quantidadeProdutosPorVendas;
	}
	
	
	
	
	
}
