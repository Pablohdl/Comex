package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class RelatorioSintetico {
	
	 int totalDeProdutosVendidos = 0;
     int totalDePedidosRealizados = 0;
     BigDecimal montanteDeVendas = BigDecimal.ZERO;
     Pedido pedidoMaisBarato = null;
     Pedido pedidoMaisCaro = null;
     HashSet<String> categoriasProcessadas = new HashSet<>();
     int totalDeCategorias = 0;
     Pedido isMaisBaratoQue;
     Pedido isMaisCaroQue;

     
     
     public RelatorioSintetico(List<Pedido> listaDePedidos) {
    	 super();
    	 if(listaDePedidos == null || listaDePedidos.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
			 this.totalDePedidosRealizados = listaDePedidos.size();
			 Function<Pedido , BigDecimal> mapeamentoPedidos = pedido -> pedido.getValorTotal();
			 this.totalDeProdutosVendidos = listaDePedidos.stream()
					 									  .mapToInt(pedido -> pedido.getQuantidade())
					 									  .sum();
			 listaDePedidos.forEach(pedido -> categoriasProcessadas.add(pedido.getCategoria()));
			 this.totalDeCategorias = categoriasProcessadas.size();
			 this.montanteDeVendas = listaDePedidos.stream().map(mapeamentoPedidos).reduce(BigDecimal.ZERO, BigDecimal::add);
			 this.pedidoMaisBarato = Pedido.isMaisBaratoQue(listaDePedidos).orElseThrow(() -> new IllegalStateException("A lista de pedidos não pode ser nula"));
			 this.pedidoMaisCaro = Pedido.isMaisCaroQue(listaDePedidos).orElseThrow(() -> new IllegalStateException("A lista de pedidos não pode ser nula"));     
     }

	public int getTotalDeProdutosVendidos() {
		return totalDeProdutosVendidos;
	}

	public int getTotalDePedidosRealizados() {
		return totalDePedidosRealizados;
	}

	public BigDecimal getMontanteDeVendas() {
		return montanteDeVendas;
	}

	public Pedido getPedidoMaisBarato() {
		return pedidoMaisBarato;
	}

	public Pedido getPedidoMaisCaro() {
		return pedidoMaisCaro;
	}
	
	public HashSet<String> getCategoriasProcessadas() {
		return categoriasProcessadas;
	}

	public int getTotalDeCategorias() {
		return totalDeCategorias;
	}

	public Pedido getIsMaisBaratoQue() {
		return isMaisBaratoQue;
	}

	public Pedido getIsMaisCaroQue() {
		return isMaisCaroQue;
	}	
		

}
