package br.com.alura.comex.repository;


import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;
import br.com.alura.comex.model.builder.CategoriaBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.tuple;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class CategoriaRepositoryTests {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void deveriaRetornar2Registros() {

        Categoria categoria1 =
                new CategoriaBuilder()
                        .comNome("Esportes")
                        .comStatus(StatusCategoria.ATIVA)
                        .build();

        Categoria categoria2 =
                new CategoriaBuilder()
                        .comNome("Carros")
                        .comStatus(StatusCategoria.ATIVA)
                        .build();

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);

        List<Categoria> resultadoFinal = categoriaRepository.findAll();

        assertThat(resultadoFinal)
                .extracting(Categoria::getNome, Categoria::getStatus)
                .contains(
                        tuple("Esportes", StatusCategoria.ATIVA),
                        tuple("Carros", StatusCategoria.ATIVA)
                );

    }

}
