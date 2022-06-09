package dao;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    public void inserirCategoria(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizarCategoria(Categoria categoria) {
        this.em.merge(categoria);
    }

    public List<Categoria> listarTodasCategorias() {
        String queryJPQL = "SELECT categoria FROM Categoria categoria";
        return em.createQuery(queryJPQL, Categoria.class).getResultList();
    }

    public List<Categoria> listarCategoriasInativas() {
        String queryJPQL = "SELECT categoria FROM Categoria categoria WHERE categoria.status = :status";
        return em.createQuery(queryJPQL, Categoria.class)
                .setParameter("status", StatusCategoria.INATIVA)
                .getResultList();
    }

}
