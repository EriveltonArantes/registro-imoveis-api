package com.registroimoveisapi.controller;

import com.registroimoveisapi.dto.CertidaoRequestDTO;
import com.registroimoveisapi.dto.CertidaoResponseDTO;
import com.registroimoveisapi.service.CertidaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Certidao", description = "Gerenciamento de certidaos")
@RestController
@RequestMapping("/api/certidaos")
public class CertidaoController {

    @Autowired
    private CertidaoService service;

    @Operation(summary = "Listar todos os Certidao")
    @GetMapping
    public List<CertidaoResponseDTO> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long imovelId) {
        List<CertidaoResponseDTO> resultado = service.listar();
        if (tipo != null && !tipo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipo() != null &&
                item.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (imovelId != null) {
            resultado = resultado.stream().filter(item -> imovelId.equals(item.getImovelId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Certidao por ID")
    @GetMapping("/{id}")
    public CertidaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Certidao")
    @PostMapping
    public ResponseEntity<CertidaoResponseDTO> criar(@Valid @RequestBody CertidaoRequestDTO certidao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(certidao));
    }

    @Operation(summary = "Atualizar Certidao")
    @PutMapping("/{id}")
    public CertidaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CertidaoRequestDTO certidao) {
        return service.atualizar(id, certidao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Certidao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
