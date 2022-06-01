package test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioProdutosMaisVendidos;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class RelatorioProdutosMaisVendidosTest {

    @Test
    public void gerarRelatorioComUmPedido (){


        Pedido pedido = new PedidoBuilder()
                .comCategoria("Informatica")
                .comProduto("Mouse")
                .comCliente("Doutor Freitas")
                .comValor("220.00")
                .comQuantidade(2)
                .comData("31/05/2022")
                .build();


      RelatorioProdutosMaisVendidos relatorio = new RelatorioProdutosMaisVendidos(Collections.singletonList(pedido));
      Assertions.assertAll(relatorio::getProdutosMaisVendidos);
      RelatorioProdutosMaisVendidos.imprimirRelatorioDeProdutosMaisVendidos(relatorio);

    }

    @Test
    public void gerarRelatorioComTresPedidos () {


        Pedido primeiroPedido = new PedidoBuilder()
                .comCategoria("ARTES")
                .comProduto("QUADRO MONALISA")
                .comCliente("Vizeu")
                .comValor("334.00")
                .comQuantidade(2)
                .comData("31/05/2022")
                .build();
        Pedido segundoPedido = new PedidoBuilder()
                .comCategoria("ARTES")
                .comProduto("VASO")
                .comCliente("Doutor Freitas")
                .comValor("2230.00")
                .comQuantidade(12)
                .comData("30/05/2022")
                .build();
        Pedido terceiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("Mouse")
                .comCliente("Doutor Freitas")
                .comValor("2240.00")
                .comQuantidade(6)
                .comData("31/05/2022")
                .build();

        List<Pedido> listaDePedidos = List.of(primeiroPedido, segundoPedido, terceiroPedido);
        RelatorioProdutosMaisVendidos relatorio = new RelatorioProdutosMaisVendidos(Collections.synchronizedList(listaDePedidos));
        Assertions.assertAll(relatorio::getProdutosMaisVendidos);
        RelatorioProdutosMaisVendidos.imprimirRelatorioDeProdutosMaisVendidos(relatorio);


    }
    }

