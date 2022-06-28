package br.com.alura.comex.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaCriarUmProduto() throws Exception {

        URI uri = new URI("/produto");

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

    }

    @Test
    public void deveriaAtualizarProduto() throws Exception {

        int idProduto = 17;
        URI uri = new URI("/produto/"+idProduto);

        JSONObject json = criarObjetoJson();
        json.put("quantidadeEstoque", 3);
        json.put("precoUnitario", 6500.00);
        String request = json.toString();

        mockMvc
                .perform(patch(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantidadeEstoque").value(3))
                .andExpect(jsonPath("$.precoUnitario").value(6500.00));

    }

    @Test
    public void deveriaListarOsProdutos() throws Exception {

        URI uri = new URI("/produto");
        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.content[0].nome").value("Teste1"))
                .andExpect(jsonPath("$.content[1].nome").value("Teste2"));

    }

    @Test
    public void deveriaPesquisarProdutoPorId() throws Exception {

        int idProduto = 18;
        URI uri = new URI("/produto/"+idProduto);

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(get(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Teste2"))
                .andExpect(jsonPath("$.descricao").value("Mesa usada"));

    }
    @Test
    public void deveriaRetornarNotFound() throws Exception {

        int idCategoria = 33333;
        URI uri = new URI("/categoria/"+idCategoria);

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(get(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());

    }

    private JSONObject criarObjetoJson() throws JSONException {
        return new JSONObject()
                .put("nome","Valorant")
                .put("descricao","Jogo")
                .put("precoUnitario",100.00)
                .put("quantidadeEstoque",  4)
                .put("idCategoria",34);


    }
}
