package br.com.alura.comex.controller;


import br.com.alura.comex.controller.dto.CategoriaDto;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

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

}
