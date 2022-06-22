package br.com.alura.comex.repository;


import br.com.alura.comex.controller.dto.RelatorioPedidosPorCategoriaProjection;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class PedidoRepositoryTests {
    @Autowired
    private PedidoRepository pedidoRepository;



    @Test
    public void deveriaCarregarRelatorioPedidosPorCategoria() {
        String nome = "Teste1";
        String nome2 = "Teste2";
        BigDecimal montanteVendido = new BigDecimal("375");
        BigDecimal montanteVendido2 = new BigDecimal("140");
        String quantidade = "3";
        String quantidade1 = "1";

        List<RelatorioPedidosPorCategoriaProjection> relatorioPedidosCategoria = pedidoRepository.findPedidosPorCategoria();

        Assertions.assertNotNull(relatorioPedidosCategoria);
        Assertions.assertEquals(2, relatorioPedidosCategoria.size());
        Assertions.assertEquals(montanteVendido, relatorioPedidosCategoria.get(0).getMontantePedido());
        Assertions.assertEquals(montanteVendido2, relatorioPedidosCategoria.get(1).getMontantePedido());
        Assertions.assertEquals(nome, relatorioPedidosCategoria.get(0).getCategoria());
        Assertions.assertEquals(nome2, relatorioPedidosCategoria.get(1).getCategoria());
        Assertions.assertEquals(quantidade, relatorioPedidosCategoria.get(0).getQuantidadeProdutos());
        Assertions.assertEquals(quantidade1, relatorioPedidosCategoria.get(1).getQuantidadeProdutos());

    }

}
