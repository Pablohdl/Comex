package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioClientesMaisLucrativos {
	
	private Map<String, List<Pedido>>clienteLucro;
	private Map<String, BigDecimal> montanteCliente;
	
	
	
	
	
	public RelatorioClientesMaisLucrativos(List<Pedido> listaDeLucrativos) {
		super();
    	if(listaDeLucrativos == null || listaDeLucrativos.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
    	this.clienteLucro = new TreeMap();
        listaDeLucrativos.stream()
                		.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteLucro.put(x, y));
    	this.montanteCliente = new TreeMap<>();
        listaDeLucrativos.stream()
                         .collect(Collectors.groupingBy(Pedido::getCliente))
                         .forEach((x,y) -> montanteCliente.put(x, y.stream().map(Pedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add)));

    	}





	public Map<String, List<Pedido>> getClienteLucro() {
		return clienteLucro;
	}





	public Map<String, BigDecimal> getMontanteCliente() {
		return montanteCliente;
	}
	
	
    
	

}
