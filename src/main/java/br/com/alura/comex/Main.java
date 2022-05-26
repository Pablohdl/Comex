package br.com.alura.comex;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        String arquivoCSV = "src/main/resources/pedidos.csv";
        List<Pedido> pedidosCSV = new ProcessadorDeCSV().getPedidos(arquivoCSV);

        String xmlPedido = "src/main/resources/pedidos.xml";
        List<Pedido> pedidosXML = new ProcessadorDeXML().getPedidos(xmlPedido);

        String jsonPedido = "src/main/resources/pedidos.json";
        List<Pedido> pedidosjson = new ProcessadorDeJSON().getPedidos(jsonPedido);

        RelatorioSintetico sintetico = new RelatorioSintetico(pedidosXML);
        RelatorioClientesFieis fidelidade = new RelatorioClientesFieis(pedidosXML);
        RelatorioCategoriaQuantidade category = new RelatorioCategoriaQuantidade(pedidosXML);
        RelatorioClientesMaisLucrativos lucrativo = new RelatorioClientesMaisLucrativos(pedidosXML);
        RelatorioProdutosMaisVendidos prod = new RelatorioProdutosMaisVendidos(pedidosXML);

        RelatorioSintetico.ImprimirRelatorioValoresTotais(sintetico);
        RelatorioClientesFieis.ImprimirRelatorioClientesFieis(fidelidade);
        RelatorioCategoriaQuantidade.ImprimirRelatorioDeCategorias(category);
        RelatorioProdutosMaisVendidos.ImprimirRelatorioDeProdutosMaisVendidos(prod);
        RelatorioClientesMaisLucrativos.ImprimirRelatorioDeClientesMaisLucrativos(lucrativo);


    }





}
