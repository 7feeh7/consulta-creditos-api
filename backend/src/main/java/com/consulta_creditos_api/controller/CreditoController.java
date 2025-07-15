package com.consulta_creditos_api.controller;

import java.util.List;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.service.CreditoService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService service;

    public CreditoController(CreditoService service) {
        this.service = service;
    }

    @GetMapping("/{numeroNfse}")
    public List<Credito> listarPorNfse(@PathVariable String numeroNfse) {
        return service.listarPorNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public Credito buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        return service.buscarPorNumeroCredito(numeroCredito);
    }
}