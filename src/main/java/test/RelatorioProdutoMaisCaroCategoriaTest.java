package test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioProdutoMaisCaroCategoria;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class RelatorioProdutoMaisCaroCategoriaTest {

    @Test
    public void deveGerarRelatorioComUmPedido()  {

        Pedido pedido = new PedidoBuilder()
                .comCategoria("ELETRÔNICOS")
                .comProduto("XBOX")
                .comCliente("Daizi")
                .comValor("2312.14")
                .comQuantidade(2)
                .comData("13/05/2022")
                .build();

        RelatorioProdutoMaisCaroCategoria relatorio = new RelatorioProdutoMaisCaroCategoria(Collections.singletonList(pedido));
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






}
