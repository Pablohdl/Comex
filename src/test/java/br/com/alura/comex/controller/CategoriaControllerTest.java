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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@AutoConfigureMockMvc
@SpringBootTest
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaCriarUmaCategoria() throws Exception {

        URI uri = new URI("/categoria");

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
    public void deveriaAtualizarStatus() throws Exception {

        int idCategoria = 90;
        URI uri = new URI("/categoria/"+idCategoria);

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(patch(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());

    }

    @Test
    public void deveriaListarAsCategorias() throws Exception {

        URI uri = new URI("/categoria");
        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$[0].nome").value("Teste1"))
                .andExpect(jsonPath("$[1].nome").value("Teste2"));

    }

    @Test
    public void deveriaPesquisarCategoriasPorId() throws Exception {

        int idCategoria = 34;
        URI uri = new URI("/categoria/"+idCategoria);

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(get(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Teste1"))
                .andExpect(jsonPath("$.status").value("ATIVA"));

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

    @Test
    public void deveriaListarRelatorioDeVendas() throws Exception {

        URI uri = new URI("/categoria/pedidos");
        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    private JSONObject criarObjetoJson() throws JSONException {
        return new JSONObject()
                .put("nome","Teste4");
    }

}
