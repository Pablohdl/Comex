package br.com.alura.comex.infra.produto;


import br.com.alura.comex.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
