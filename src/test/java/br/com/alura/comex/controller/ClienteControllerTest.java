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
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaCriarUmCliente() throws Exception {

        URI uri = new URI("/cliente");

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
    public void deveriaAtualizarCliente() throws Exception {

        int idCliente = 1;
        URI uri = new URI("/cliente/"+idCliente);

        JSONObject json = criarObjetoJson();
        json.put("nome","Pablo");
        json.put("telefone", "99999999000");
        json.put("cpf", "33344455566");
        String request = json.toString();

        mockMvc
                .perform(patch(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Pablo"))
                .andExpect(jsonPath("$.telefone").value("99999999000"))
                .andExpect(jsonPath("$.cpf").value("33344455566"));

    }



    @Test
    public void deveriaPesquisarClientePorId() throws Exception {

        int idCliente = 1;
        URI uri = new URI("/cliente/"+idCliente);

        JSONObject json = criarObjetoJson();
        String request = json.toString();

        mockMvc
                .perform(get(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Pablo"));

    }
    @Test
    public void deveriaRetornarNotFound() throws Exception {

        int idCliente = 33333;
        URI uri = new URI("/cliente/"+idCliente);

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
                .put("nome","Cleiton")
                .put("cpf", "12345689010")
                .put("telefone","819993232")
                .put("rua", "Hollywood Bleeding")
                .put("numero", "1233")
                .put("bairro", "Candeias")
                .put("cidade", "Long Island")
                .put("estado", "Long Island");

    }
}
