package com.consulta_creditos_api.controller;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CreditoController.class)
public class CreditoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService creditoService;

    @Test
    void listarPorNfse_deveRetornarLista() throws Exception {
        Credito c1 = new Credito();
        Credito c2 = new Credito();
        when(creditoService.listarPorNfse("7891011")).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/api/creditos/7891011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void buscarPorNumeroCredito_deveRetornarCredito() throws Exception {
        Credito credito = new Credito();
        credito.setNumeroCredito("123456");
        when(creditoService.buscarPorNumeroCredito("123456")).thenReturn(credito);

        mockMvc.perform(get("/api/creditos/credito/123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroCredito").value("123456"));
    }

    @Test
    void buscarPorNumeroCredito_deveRetornar404SeNaoExiste() throws Exception {
        when(creditoService.buscarPorNumeroCredito("000000")).thenReturn(null);

        mockMvc.perform(get("/api/creditos/credito/000000"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}