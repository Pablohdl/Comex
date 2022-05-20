package br.com.alura.comex;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioClientesFieis {
	
	private Map<String, List<Pedido>>clienteMaisFiel;

	
	
	
	public RelatorioClientesFieis(List<Pedido> listaDeClientes) {
	super();
	if(listaDeClientes == null || listaDeClientes.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
	 this.clienteMaisFiel = new TreeMap();
     listaDeClientes.stream()
             		.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteMaisFiel.put(x, y));
	}
		
	
	public Map<String, List<Pedido>> getClienteMaisFiel() {
		return clienteMaisFiel;
	}



}
