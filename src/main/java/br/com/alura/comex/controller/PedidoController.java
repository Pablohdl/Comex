package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.PedidoDto;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
