package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDetalheDto;
import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.ProdutoDetalheDto;
import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.controller.form.AtualizacaoProdutoForm;
import br.com.alura.comex.controller.form.ProdutoForm;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter(categoriaRepository);
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }


    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable Long id, @RequestBody @Valid AtualizacaoProdutoForm form) {
        Optional<Produto> optional = produtoRepository.findById(id);

        if (optional.isPresent()){
            Produto produto = form.atualizar(id, produtoRepository);
            return ResponseEntity.ok(new ProdutoDto(produto));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDetalheDto>> listarTodos(@RequestParam(defaultValue = "0")int pagina) {
        Pageable pageable = PageRequest.of(pagina, 5, Sort.by(Sort.Direction.ASC, "nome"));
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        Page<ProdutoDetalheDto> produtoDetalheDto = ProdutoDetalheDto.converterPagina(produtos);
        return ResponseEntity.ok().body(produtoDetalheDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> encontrarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent())
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        return ResponseEntity.notFound().build();
    }
}
