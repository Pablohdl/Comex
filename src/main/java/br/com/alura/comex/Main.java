package br.com.alura.comex;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
      
    	String arquivoCSV = "pedidos.csv";
    	ProcessadorDeCSV processador = new ProcessadorDeCSV();
    	
    	List<Pedido> listaDePedidos = ProcessadorDeCSV.listarPedidos(arquivoCSV); 	
    	List<Pedido> listaDeClientes = ProcessadorDeCSV.listarPedidos(arquivoCSV);	
    	List<Pedido> listaDeCategorias = ProcessadorDeCSV.listarPedidos(arquivoCSV);
    	List<Pedido> listaDeLucrativos = ProcessadorDeCSV.listarPedidos(arquivoCSV);
    	List<Pedido> listaDeProdutos = ProcessadorDeCSV.listarPedidos(arquivoCSV);
    	
    	RelatorioSintetico sintetico = new RelatorioSintetico(listaDePedidos);
    	RelatorioClientesFieis fidelidade = new RelatorioClientesFieis(listaDeClientes);
    	RelatorioCategoriaMaisVendidas category = new RelatorioCategoriaMaisVendidas(listaDeCategorias);
    	RelatorioClientesMaisLucrativos lucrativo = new RelatorioClientesMaisLucrativos(listaDeLucrativos);
    	RelatorioProdutosMaisVendidos prod = new RelatorioProdutosMaisVendidos(listaDePedidos);
    	
    	
        

        System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", sintetico.getTotalDePedidosRealizados());
        System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", sintetico.getTotalDeProdutosVendidos());
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", sintetico.getTotalDeCategorias());
        System.out.printf("- MONTANTE DE VENDAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getMontanteDeVendas().setScale(2, RoundingMode.HALF_DOWN)));
        System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getPedidoMaisBarato().getValorTotal()), sintetico.getPedidoMaisBarato().getProduto());
        System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sintetico.getPedidoMaisCaro().getValorTotal()), sintetico.getPedidoMaisCaro().getProduto());
        System.out.println("############################");
        System.out.println("#### RELATÓRIO DE CLIENTES FIEIS");
        fidelidade.getClienteMaisFiel().forEach((x, y) -> System.out.printf("\nNOME: %s \nN° De Pedidos: %s\n", x, y.size()));
        System.out.println("############################");
        System.out.println("#### RELATÓRIO DE CATEGORIAS");
        category.getMontanteCategoria().forEach((x, y) -> System.out.printf("\nNOME: %s \nMontante: %s\nQuantidade Vendida: %s\n", x, y,category.getQuantidadeProdutosPorCategoria().put(x,null)));
        System.out.println("############################");
        System.out.println("####RELATORIO PRODUTO MAIS VENDIDO");
        prod.getQuantidadeProdutosPorVendas().forEach((x, y) -> System.out.printf("\nProduto: %s \nPedidos: %s\n", x, y));
        System.out.println("############################");
        System.out.println("####RELATORIO CLIENTE MAIS LUCRATIVO");
        lucrativo.getClienteLucro().forEach((x, y) -> System.out.printf("\nNOME: %s \nPedidos: %s\nMontante: %s\n", x, y.size(),lucrativo.getMontanteCliente().put(x,null)));

}
}
