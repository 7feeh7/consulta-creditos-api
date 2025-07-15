package com.consulta_creditos_api.controller;

import java.util.List;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.service.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Créditos", description = "Endpoints de consulta de créditos")
@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService service;

    public CreditoController(CreditoService service) {
        this.service = service;
    }

    @Operation(summary = "Consulta créditos por número da NFS-e")
    @GetMapping("/{numeroNfse}")
    public List<Credito> listarPorNfse(@PathVariable String numeroNfse) {
        return service.listarPorNfse(numeroNfse);
    }

    @Operation(summary = "Consulta crédito por número do crédito constituído")
    @GetMapping("/credito/{numeroCredito}")
    public Credito buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        return service.buscarPorNumeroCredito(numeroCredito);
    }
}