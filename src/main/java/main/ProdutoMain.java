package main;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.model.StatusCategoria;
import br.com.alura.comex.model.builder.ProdutoBuilder;
import dao.ProdutoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("comexdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        cadastrandoProdutos(entityManager);
        listarProdutosIndisponiveis(entityManager);


    }

    private static void listarProdutosIndisponiveis(EntityManager entityManager) {
        ProdutoDAO pd = new ProdutoDAO(entityManager);
        entityManager.getTransaction().begin();
        List<Produto> listaIndisponivel = pd.listarProdutosIndisponiveis();
        entityManager.getTransaction().commit();
        entityManager.close();

        listaIndisponivel.stream().forEach(System.out::println);
    }

    private static void cadastrandoProdutos(EntityManager entityManager) {
        Produto produto1 = new ProdutoBuilder()
                .comNome("Resident evil")
                .comCategoria(new Categoria("JOGOS", StatusCategoria.ATIVA))
                .comDescricao("Jogo de FPS")
                .comPrecoUnitario(new BigDecimal("123.00"))
                .quantidadeEmEstoque(1)
                .build();

        Produto produto2 = new ProdutoBuilder()
                .comNome("Guitarra")
                .comCategoria(new Categoria("MÚSICA", StatusCategoria.ATIVA))
                .comDescricao("Instrumento musical")
                .comPrecoUnitario(new BigDecimal("2213.00"))
                .quantidadeEmEstoque(2)
                .build();

        Produto produto3 = new ProdutoBuilder()
                .comNome("LAPIS")
                .comCategoria(new Categoria("ARTES", StatusCategoria.ATIVA))
                .comDescricao("Quadro de pintar")
                .comPrecoUnitario(new BigDecimal("113.00"))
                .quantidadeEmEstoque(0)
                .build();

        Produto produto4 = new ProdutoBuilder()
                .comNome("PAINEL")
                .comCategoria(new Categoria("ARTES", StatusCategoria.ATIVA))
                .comDescricao("TINTA")
                .comPrecoUnitario(new BigDecimal("13.00"))
                .quantidadeEmEstoque(0)
                .build();


        ProdutoDAO pd = new ProdutoDAO(entityManager);

        entityManager.getTransaction().begin();

        pd.inserirProduto(produto1);
        pd.inserirProduto(produto2);
        pd.inserirProduto(produto3);
        pd.inserirProduto(produto4);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
