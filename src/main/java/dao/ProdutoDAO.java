package dao;

import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void inserirProduto(Produto produto) {
        this.em.persist(produto);
    }

    public List<Produto> listarProdutosIndisponiveis() {
        String queryJPQL = "SELECT produto FROM Produto produto WHERE produto.quantidadeEstoque = 0";
        return em.createQuery(queryJPQL, Produto.class).getResultList();
    }

    public List<Produto> listarTodosProdutos() {
        String queryJPQL = "SELECT produto FROM Produto produto";
        return em.createQuery(queryJPQL, Produto.class)
                .getResultList();
    }



}
