package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.PedidoDto;
import br.com.alura.comex.controller.form.PedidoForm;
import br.com.alura.comex.domain.pedido.Pedido;
import br.com.alura.comex.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
   private PedidoRepository pedidoRepository;

    @GetMapping
    public List<PedidoDto> lista(Long id) {
        if(id == null) {
            List<Pedido> pedidos = pedidoRepository.findAll();
            return PedidoDto.converter(pedidos);
        } else {
            Optional<Pedido> pedidos = pedidoRepository.findById(id);
            return PedidoDto.converterOp(pedidos);
        }
    }
    @PostMapping
    public ResponseEntity<PedidoDto> cadastrarPedido(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
        Pedido pedido = form.converter();
        pedidoRepository.save(pedido);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPedido(@PathVariable Long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> encontrarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent())
            return ResponseEntity.ok(new PedidoDto(pedido.get()));
        return ResponseEntity.notFound().build();
    }



}
