package br.com.alura.comex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;

public class RelatorioSintetico {
	
	private int totalDeProdutosVendidos = 0;
     private int totalDePedidosRealizados = 0;
     private BigDecimal montanteDeVendas = BigDecimal.ZERO;
     private Pedido pedidoMaisBarato = null;
     private Pedido pedidoMaisCaro = null;
     private HashSet<String> categoriasProcessadas = new HashSet<>();
     private int totalDeCategorias = 0;





     public RelatorioSintetico(List<Pedido> listaDePedidos) {
    	 super();
    	 if(listaDePedidos == null || listaDePedidos.isEmpty()) throw new IllegalArgumentException("A lista não pode ser nula.");
		 Function<Pedido, BigDecimal> mapeamentoPedidos = getPedidoTotalDeProdutosVendidos(listaDePedidos);
		 pegarCategoriaProcessadas(listaDePedidos);
		 montante(listaDePedidos, mapeamentoPedidos);
		 pedidosMaisCaroMaisBarato(listaDePedidos);
	 }

	private Function<Pedido, BigDecimal> getPedidoTotalDeProdutosVendidos(List<Pedido> listaDePedidos) {
		this.totalDePedidosRealizados = listaDePedidos.size();
		Function<Pedido , BigDecimal> mapeamentoPedidos = pedido -> pedido.getValorTotal();
		this.totalDeProdutosVendidos = listaDePedidos.stream()
													  .mapToInt(pedido -> pedido.getQuantidade())
													  .sum();
		return mapeamentoPedidos;
	}

	private void pedidosMaisCaroMaisBarato(List<Pedido> listaDePedidos) {

		this.pedidoMaisBarato = listaDePedidos.stream().min(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalStateException("A lista de pedidos não pode ser nula"));

		this.pedidoMaisCaro = listaDePedidos.stream().max(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalStateException("A lista de pedidos não pode ser nula"));
	}

	private void pegarCategoriaProcessadas(List<Pedido> listaDePedidos) {
		listaDePedidos.forEach(pedido -> categoriasProcessadas.add(pedido.getCategoria()));
		this.totalDeCategorias = categoriasProcessadas.size();
	}

	private void montante(List<Pedido> listaDePedidos, Function<Pedido, BigDecimal> mapeamentoPedidos) {
		this.montanteDeVendas = listaDePedidos.stream().map(mapeamentoPedidos).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static void imprimirRelatorioValoresTotais(RelatorioSintetico sintetico) {
		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", sintetico.getTotalDePedidosRealizados());
		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", sintetico.getTotalDeProdutosVendidos());
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", sintetico.getTotalDeCategorias());
		System.out.printf("- MONTANTE DE VENDAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getMontanteDeVendas().setScale(2, RoundingMode.HALF_DOWN)));
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getPedidoMaisBarato().getValorTotal()), sintetico.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getPedidoMaisCaro().getValorTotal()), sintetico.getPedidoMaisCaro().getProduto());
		System.out.println("############################");
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




}

