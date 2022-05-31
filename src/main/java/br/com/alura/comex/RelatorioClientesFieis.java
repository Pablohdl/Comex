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

		AgrupandoClientesMaisFieis(listaDeClientes);
	}

	private void AgrupandoClientesMaisFieis(List<Pedido> listaDeClientes) {
		listaDeClientes.stream()
						.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteMaisFiel.put(x, y));
	}

	public static void imprimirRelatorioClientesFieis(RelatorioClientesFieis fidelidade) {
		System.out.println("#### RELATÓRIO DE CLIENTES FIEIS");
		fidelidade.getClienteMaisFiel().forEach((x, y) -> System.out.printf("\nNOME: %s \nN° De Pedidos: %s\n", x, y.size()));
	}



	public Map<String, List<Pedido>> getClienteMaisFiel() {
		return clienteMaisFiel;
	}



}
