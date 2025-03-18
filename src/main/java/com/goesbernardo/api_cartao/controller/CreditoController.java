package com.goesbernardo.api_cartao.controller;

import com.goesbernardo.api_cartao.dto.CreditoDTO;
import com.goesbernardo.api_cartao.service.CreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping
    public ResponseEntity<List<CreditoDTO>> listarCreditos() {
        List<CreditoDTO> creditos = creditoService.buscarTodos();
        return ResponseEntity.ok(creditos);
    }

    @GetMapping(value = "/{numeroNfse}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditoDTO> buscarPorNumeroNfse(@PathVariable String numeroNfse) {
        CreditoDTO creditoDTO = creditoService.buscarPorNumeroNfse(numeroNfse);
        return creditoDTO != null ? ResponseEntity.ok(creditoDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/credito/{numeroCredito}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditoDTO> buscarCreditoPorNumero(@PathVariable String numeroCredito) {
        Optional<CreditoDTO> creditoDTO = creditoService.buscarPorNumeroCredito(numeroCredito);
        return creditoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CreditoDTO> criarCredito(@RequestBody CreditoDTO creditoDTO) {
        CreditoDTO creditoSalvo = creditoService.salvarCredito(creditoDTO);
        return new ResponseEntity<>(creditoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        creditoService.deletar(id);
    }
}
