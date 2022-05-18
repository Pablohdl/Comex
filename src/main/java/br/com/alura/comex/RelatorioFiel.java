package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioFiel {
	
	Map<String, List<Pedido>>clienteMaisFiel;
    Pedido clienteFielMax;
    
	
	
	
	public RelatorioFiel(List<Pedido> listaDeClientes) {
	super();
	if(listaDeClientes == null || listaDeClientes.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
	 this.clienteMaisFiel = new TreeMap();
     listaDeClientes.stream()
             		.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteMaisFiel.put(x, y));
	}
		
	
	public Map<String, List<Pedido>> getClienteMaisFiel() {
		return clienteMaisFiel;
	}


	public Pedido getClienteFielMax() {
		return clienteFielMax;
	}


}
