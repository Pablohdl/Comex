package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

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
}
