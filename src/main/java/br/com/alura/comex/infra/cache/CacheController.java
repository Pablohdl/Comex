package br.com.alura.comex.infra.cache;

import br.com.alura.comex.infra.categoria.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.infra.pedido.PedidoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CacheController {

    PedidoRepository pedidoRepository;

    @GetMapping("/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSB2ZW5kYXM")
    @CacheEvict(value = "relatorioDePedidos", allEntries = true)
    public ResponseEntity<?> invalidarCacheRelatorioPedidos() {
        return ResponseEntity.ok().build();
    }
}
