package com.consulta_creditos_api.service;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.repository.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    private final CreditoRepository repository;

    public CreditoService(CreditoRepository repository) {
        this.repository = repository;
    }

    public List<Credito> listarPorNfse(String numeroNfse) {
        return repository.findByNumeroNfse(numeroNfse);
    }

    public Optional<Credito> buscarPorNumeroCredito(String numeroCredito) {
        Optional<Credito> teste = repository.findByNumeroCredito(numeroCredito);
        teste.ifPresentOrElse(
                credito -> System.out.println("Credito encontrado: " + credito),
                () -> System.out.println("Credito não encontrado")
        );
        return teste;
    }
}