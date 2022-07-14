package br.com.alura.comex.infra.categoria;


import br.com.alura.comex.infra.categoria.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.infra.categoria.CategoriaDto;
import br.com.alura.comex.infra.categoria.AtualizarStatusForm;
import br.com.alura.comex.infra.categoria.CategoriaForm;
import br.com.alura.comex.domain.categoria.Categoria;
import br.com.alura.comex.infra.categoria.CategoriaRepository;
import br.com.alura.comex.infra.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<CategoriaDto> lista(Long id) {
        if(id == null) {
            List<Categoria> categorias = categoriaRepository.findAll();
            return CategoriaDto.converter(categorias);
        } else {
           Optional<Categoria> categorias = categoriaRepository.findById(id);
            return CategoriaDto.converterOp(categorias);
        }
    }


    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {
       Categoria categoria = form.converter();
       categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> atualizarStatusCategoria(@PathVariable Long id, @Valid AtualizarStatusForm form) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            Categoria categoria = form.atualizarStatus(id, categoriaRepository);
            return ResponseEntity.ok(new CategoriaDto(categoria));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedidos")
    @Cacheable(value = "relatorioDePedidos")
    public List<RelatorioPedidosPorCategoriaProjection> mostrarPedidosPorCategoria() {
        List<RelatorioPedidosPorCategoriaProjection> lista = categoriaRepository.findPedidosPorCategoria();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> encontrarPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent())
            return ResponseEntity.ok(new CategoriaDto(categoria.get()));
        return ResponseEntity.notFound().build();
    }

}
