package com.consulta_creditos_api.controller;

import java.util.List;

import com.consulta_creditos_api.model.Credito;
import com.consulta_creditos_api.service.CreditoService;
import com.consulta_creditos_api.service.KafkaPublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Créditos", description = "Endpoints de consulta de créditos")
@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService service;
    private final KafkaPublisherService kafkaPublisherService;

    public CreditoController(CreditoService service, KafkaPublisherService kafkaPublisherService) {
        this.service = service;
        this.kafkaPublisherService = kafkaPublisherService;
    }

    @Operation(summary = "Consulta créditos por número da NFS-e")
    @GetMapping("/{numeroNfse}")
    public List<Credito> listarPorNfse(@PathVariable String numeroNfse) {
        kafkaPublisherService.publishConsulta("Consulta por NFS-e: " + numeroNfse);
        return service.listarPorNfse(numeroNfse);
    }

    @Operation(summary = "Consulta crédito por número do crédito constituído")
    @GetMapping("/credito/{numeroCredito}")
    public Credito buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        kafkaPublisherService.publishConsulta("Consulta por número de crédito: " + numeroCredito);
        return service.buscarPorNumeroCredito(numeroCredito);
    }
}