package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.RelatorioPedidosPorCategoriaProjection;
import br.com.alura.comex.controller.form.AtualizacaoCategoriaForm;
import br.com.alura.comex.controller.dto.CategoriaDto;
import br.com.alura.comex.controller.form.CategoriaForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.repository.CategoriaRepository;
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> atualizarCategoria(@PathVariable Long id, @RequestBody @Valid AtualizacaoCategoriaForm form) {
        Optional<Categoria> optional = categoriaRepository.findById(id);

        if (optional.isPresent()){
            Categoria categoria = form.atualizar(id, categoriaRepository);
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
    public List<RelatorioPedidosPorCategoriaProjection> mostrarPedidosPorCategoria() {
        List<RelatorioPedidosPorCategoriaProjection> lista = pedidoRepository.findPedidosPorCategoria();
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
