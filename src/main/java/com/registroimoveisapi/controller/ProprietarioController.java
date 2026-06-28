package com.registroimoveisapi.controller;

import com.registroimoveisapi.dto.ProprietarioRequestDTO;
import com.registroimoveisapi.dto.ProprietarioResponseDTO;
import com.registroimoveisapi.service.ProprietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Proprietario", description = "Gerenciamento de proprietarios")
@RestController
@RequestMapping("/api/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioService service;

    @Operation(summary = "Listar todos os Proprietario")
    @GetMapping
    public List<ProprietarioResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long imovelId) {
        List<ProprietarioResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (imovelId != null) {
            resultado = resultado.stream().filter(item -> imovelId.equals(item.getImovelId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Proprietario por ID")
    @GetMapping("/{id}")
    public ProprietarioResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Proprietario")
    @PostMapping
    public ResponseEntity<ProprietarioResponseDTO> criar(@Valid @RequestBody ProprietarioRequestDTO proprietario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(proprietario));
    }

    @Operation(summary = "Atualizar Proprietario")
    @PutMapping("/{id}")
    public ProprietarioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ProprietarioRequestDTO proprietario) {
        return service.atualizar(id, proprietario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Proprietario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
