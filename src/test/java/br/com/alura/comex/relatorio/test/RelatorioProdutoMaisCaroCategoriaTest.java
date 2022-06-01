package br.com.alura.comex.relatorio.test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioProdutoMaisCaroCategoria;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class RelatorioProdutoMaisCaroCategoriaTest {

    @Test
    public void deveGerarRelatorioComUmProdutoMaisCaroDeCadaCategoria()  {

        Pedido primeiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("XBOX")
                .comCliente("Vivian")
                .comValor("2350.14")
                .comQuantidade(2)
                .comData("13/05/2022")
                .build();

        Pedido segundoPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("PS5")
                .comCliente("Daizi")
                .comValor("2343.14")
                .comQuantidade(2)
                .comData("16/05/2022")
                .build();
        Pedido terceiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("PC")
                .comCliente("Arthur")
                .comValor("2363.14")
                .comQuantidade(2)
                .comData("12/05/2022")
                .build();

        List<Pedido> listaDePedidos = List.of(primeiroPedido, segundoPedido, terceiroPedido);
        RelatorioProdutoMaisCaroCategoria relatorio = new RelatorioProdutoMaisCaroCategoria(Collections.synchronizedList(listaDePedidos));
        Assertions.assertAll(relatorio::getProdutosMaisCarosCatego);
        RelatorioProdutoMaisCaroCategoria.imprimirRelatorioDeProdutosMaisCaroCategoria(relatorio);

    }
    @Test
    public void deveGerarRelatorioVazio() throws Exception  {
        List<Pedido> pedidonulo = Collections.emptyList();
        RelatorioProdutoMaisCaroCategoria relatoriovazio = new RelatorioProdutoMaisCaroCategoria(pedidonulo);
        Assertions.assertAll(relatoriovazio::getProdutosMaisCarosCatego);
        RelatorioProdutoMaisCaroCategoria.imprimirRelatorioDeProdutosMaisCaroCategoria(relatoriovazio);

    }

    @Test
    public void deveGerarRelatorioComDuasCategorias() {


        Pedido primeiroPedido = new PedidoBuilder()
                .comCategoria("ELETRÔNICOS")
                .comProduto("XBOX")
                .comCliente("Manoel")
                .comValor("2312.14")
                .comQuantidade(2)
                .comData("13/05/2022")
                .build();

        Pedido segundoPedido = new PedidoBuilder()
                .comCategoria("ELETRÔNICOS")
                .comProduto("PS5")
                .comCliente("Daizi")
                .comValor("2343.14")
                .comQuantidade(2)
                .comData("16/05/2022")
                .build();
        Pedido terceiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("PC")
                .comCliente("Sergio")
                .comValor("2323.14")
                .comQuantidade(2)
                .comData("12/05/2022")
                .build();
        List<Pedido> listaDePedidos = List.of(primeiroPedido, segundoPedido, terceiroPedido);
        RelatorioProdutoMaisCaroCategoria relatorio = new RelatorioProdutoMaisCaroCategoria(Collections.synchronizedList(listaDePedidos));
        Assertions.assertAll(relatorio::getProdutosMaisCarosCatego);
        RelatorioProdutoMaisCaroCategoria.imprimirRelatorioDeProdutosMaisCaroCategoria(relatorio);
    }






}
