package com.consulta_creditos_api.service;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.repository.CreditoRepository;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreditoServiceTest {
    @Test
    void listarPorNfse_deveRetornarListaDeCreditos() {
        CreditoRepository mockRepo = mock(CreditoRepository.class);
        CreditoService service = new CreditoService(mockRepo);

        Credito credito1 = new Credito();
        Credito credito2 = new Credito();
        when(mockRepo.findByNumeroNfse("7891011")).thenReturn(List.of(credito1, credito2));

        List<Credito> result = service.listarPorNfse("7891011");

        assertEquals(2, result.size());
        verify(mockRepo, times(1)).findByNumeroNfse("7891011");
    }

    @Test
    void buscarPorNumeroCredito_deveRetornarCreditoQuandoExiste() {
        CreditoRepository mockRepo = mock(CreditoRepository.class);
        CreditoService service = new CreditoService(mockRepo);

        Credito credito = new Credito();
        when(mockRepo.findByNumeroCredito("123456")).thenReturn(credito);

        Credito result = service.buscarPorNumeroCredito("123456");

        assertNotNull(result);
        verify(mockRepo, times(1)).findByNumeroCredito("123456");
    }

    @Test
    void buscarPorNumeroCredito_deveRetornarNullQuandoNaoExiste() {
        CreditoRepository mockRepo = mock(CreditoRepository.class);
        CreditoService service = new CreditoService(mockRepo);

        when(mockRepo.findByNumeroCredito("000000")).thenReturn(null);

        Credito result = service.buscarPorNumeroCredito("000000");

        assertNull(result);
        verify(mockRepo).findByNumeroCredito("000000");
    }
}
