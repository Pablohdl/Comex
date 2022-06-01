package test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioCategoriaQuantidade;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class RelatorioCategoriaQuantidadeTest {


    @Test
    public void deveGerarRelatorioVazio() throws Exception {
        List<Pedido> pedidonulo = Collections.emptyList();
        RelatorioCategoriaQuantidade relatoriovazio = new RelatorioCategoriaQuantidade(pedidonulo);
        Assertions.assertAll(relatoriovazio::getVendasPorCategoria);
        RelatorioCategoriaQuantidade.imprimirRelatorioDeCategorias(relatoriovazio);
        //Assertions.assertThrows(IllegalArgumentException.class ,() ->RelatorioCategoriaQuantidade.imprimirRelatorioDeCategorias(relatoriovazio));
    }

    @Test
    public void deveGerarRelatorioComTresPedidosDaMesmaCategoria() {
        Pedido primeiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("PC GAMER")
                .comCliente("SERGIO")
                .comValor("3333.40")
                .comQuantidade(3)
                .comData("25/03/2022")
                .build();

        Pedido segundoPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("MOUSE GAMER")
                .comCliente("DOUGLAS")
                .comValor("250.99")
                .comQuantidade(1)
                .comData("26/03/2022")
                .build();

        Pedido terceiroPedido = new PedidoBuilder()
                .comCategoria("INFORMATICA")
                .comProduto("GAMEBOY")
                .comCliente("DOUGLAS")
                .comValor("33432.00")
                .comQuantidade(1)
                .comData("22/05/2022")
                .build();


        List<Pedido> listaDePedidos = List.of(primeiroPedido, segundoPedido, terceiroPedido);
        RelatorioCategoriaQuantidade relatorio = new RelatorioCategoriaQuantidade(Collections.synchronizedList(listaDePedidos));
        Assertions.assertAll(relatorio::getVendasPorCategoria);
        RelatorioCategoriaQuantidade.imprimirRelatorioDeCategorias(relatorio);
    }
}
