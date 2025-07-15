package com.consulta_creditos_api.service;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.repository.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoService {

    private final CreditoRepository repository;

    public CreditoService(CreditoRepository repository) {
        this.repository = repository;
    }

    public List<Credito> listarPorNfse(String numeroNfse) {
        return repository.findByNumeroNfse(numeroNfse);
    }

    public Credito buscarPorNumeroCredito(String numeroCredito) {
        return repository.findByNumeroCredito(numeroCredito);
    }
}