package test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioProdutosMaisVendidos;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;

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
    }

