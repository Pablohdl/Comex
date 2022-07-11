package br.com.alura.comex.controller.form;

import br.com.alura.comex.domain.categoria.Categoria;
import br.com.alura.comex.domain.enun.StatusCategoria;
import br.com.alura.comex.repository.CategoriaRepository;

public class AtualizarStatusForm {

    public Categoria atualizarStatus(Long id, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        if (categoria.getStatus().equals(StatusCategoria.ATIVA)) {
            categoria.setStatus(StatusCategoria.INATIVA);
            return categoria;
        }
        categoria.setStatus(StatusCategoria.ATIVA);
        return categoria;
    }
}
