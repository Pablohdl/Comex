package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.controller.form.AtualizacaoProdutoForm;
import br.com.alura.comex.controller.form.AtualizarCategoriaStatusForm;
import br.com.alura.comex.controller.form.CategoriaForm;
import br.com.alura.comex.controller.form.ProdutoForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Transient;
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

    @GetMapping
    public List<ProdutoDto> lista(Long id) {
        if(id == null) {
            List<Produto> produtos = produtoRepository.findAll();
            return ProdutoDto.converter(produtos);
        } else {
            Optional<Produto> produtos = produtoRepository.findById(id);
            return ProdutoDto.converterOp(produtos);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter(categoriaRepository);
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }


    @PutMapping("/{id}")
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
}
