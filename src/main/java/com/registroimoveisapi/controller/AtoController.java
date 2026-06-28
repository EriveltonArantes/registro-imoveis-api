package com.registroimoveisapi.controller;

import com.registroimoveisapi.dto.AtoRequestDTO;
import com.registroimoveisapi.dto.AtoResponseDTO;
import com.registroimoveisapi.service.AtoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Ato", description = "Gerenciamento de atos")
@RestController
@RequestMapping("/api/atos")
public class AtoController {

    @Autowired
    private AtoService service;

    @Operation(summary = "Listar todos os Ato")
    @GetMapping
    public List<AtoResponseDTO> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long imovelId) {
        List<AtoResponseDTO> resultado = service.listar();
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

    @Operation(summary = "Buscar Ato por ID")
    @GetMapping("/{id}")
    public AtoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Ato")
    @PostMapping
    public ResponseEntity<AtoResponseDTO> criar(@Valid @RequestBody AtoRequestDTO ato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(ato));
    }

    @Operation(summary = "Atualizar Ato")
    @PutMapping("/{id}")
    public AtoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AtoRequestDTO ato) {
        return service.atualizar(id, ato);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Ato")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
