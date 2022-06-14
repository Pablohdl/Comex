package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.PedidoDto;
import br.com.alura.comex.controller.form.ClienteForm;
import br.com.alura.comex.controller.form.PedidoForm;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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




}
