package test;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoBuilder;
import br.com.alura.comex.relatorios.RelatorioClientesMaisLucrativos;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class RelatorioClientesMaisLucrativosTest {



    @Test
    public void gerarRelatorioComTresPedidosDoMesmoCliente() {
        Pedido primeiroPedido = new PedidoBuilder()
                .comCategoria("DECORAÇÃO")
                .comProduto("QUADRO NEGRO")
                .comCliente("DOUGLAS")
                .comValor("312.40")
                .comQuantidade(1)
                .comData("25/03/2022")
                .build();

        Pedido segundoPedido = new PedidoBuilder()
                .comCategoria("MÚSICA")
                .comProduto("PANDEIRO")
                .comCliente("DOUGLAS")
                .comValor("250.99")
                .comQuantidade(1)
                .comData("26/03/2022")
                .build();

        Pedido terceiroPedido = new PedidoBuilder()
                .comCategoria("ELETRÔNICOS")
                .comProduto("GAMEBOY")
                .comCliente("DOUGLAS")
                .comValor("33432.00")
                .comQuantidade(1)
                .comData("22/05/2022")
                .build();

        List<Pedido> listaDePedidos = List.of(primeiroPedido, segundoPedido, terceiroPedido);
        RelatorioClientesMaisLucrativos relatorio = new RelatorioClientesMaisLucrativos(Collections.synchronizedList(listaDePedidos));
        Assertions.assertAll(relatorio::getClientesLucrativos);
        RelatorioClientesMaisLucrativos.imprimirRelatorioDeClientesMaisLucrativos(relatorio);

    }
}
