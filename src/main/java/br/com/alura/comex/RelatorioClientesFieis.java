package br.com.alura.comex;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RelatorioClientesFieis {
	
<<<<<<< HEAD
	Map<String, List<Pedido>>clienteMaisFiel;
=======
	private Map<String, List<Pedido>>clienteMaisFiel;
>>>>>>> 6a982afa247369bab4370a880d5352a6b0039df2

	
	
	
	public RelatorioClientesFieis(List<Pedido> listaDeClientes) {
	super();
	if(listaDeClientes == null || listaDeClientes.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
	 this.clienteMaisFiel = new TreeMap();
<<<<<<< HEAD
		AgrupandoClientesMaisFieis(listaDeClientes);
	}

	private void AgrupandoClientesMaisFieis(List<Pedido> listaDeClientes) {
		listaDeClientes.stream()
						.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteMaisFiel.put(x, y));
	}

	public static void ImprimirRelatorioClientesFieis(RelatorioClientesFieis fidelidade) {
		System.out.println("#### RELATÓRIO DE CLIENTES FIEIS");
		fidelidade.getClienteMaisFiel().forEach((x, y) -> System.out.printf("\nNOME: %s \nN° De Pedidos: %s\n", x, y.size()));
	}



=======
     listaDeClientes.stream()
             		.collect(Collectors.groupingBy(Pedido::getCliente)).forEach((x, y) -> clienteMaisFiel.put(x, y));
	}
		
	
>>>>>>> 6a982afa247369bab4370a880d5352a6b0039df2
	public Map<String, List<Pedido>> getClienteMaisFiel() {
		return clienteMaisFiel;
	}



<<<<<<< HEAD

=======
>>>>>>> 6a982afa247369bab4370a880d5352a6b0039df2
}
