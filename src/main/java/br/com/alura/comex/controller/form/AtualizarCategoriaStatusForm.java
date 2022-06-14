package br.com.alura.comex.controller.form;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;
import br.com.alura.comex.repository.CategoriaRepository;

public class AtualizarCategoriaStatusForm {

    private StatusCategoria status;

    public AtualizarCategoriaStatusForm(Categoria categoria) {
        this.status = categoria.getStatus();
    }

    public StatusCategoria getStatus() {
        return status;
    }

    public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        categoria.setStatus(this.status);
        return categoria;
    }

}
