package com.registroimoveisapi.controller;

import com.registroimoveisapi.dto.ImovelRequestDTO;
import com.registroimoveisapi.dto.ImovelResponseDTO;
import com.registroimoveisapi.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Imovel", description = "Gerenciamento de imovels")
@RestController
@RequestMapping("/api/imovels")
public class ImovelController {

    @Autowired
    private ImovelService service;

    @Operation(summary = "Listar todos os Imovel")
    @GetMapping
    public List<ImovelResponseDTO> listar(@RequestParam(required = false) String descricao) {
        List<ImovelResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Imovel por ID")
    @GetMapping("/{id}")
    public ImovelResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Imovel")
    @PostMapping
    public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO imovel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(imovel));
    }

    @Operation(summary = "Atualizar Imovel")
    @PutMapping("/{id}")
    public ImovelResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ImovelRequestDTO imovel) {
        return service.atualizar(id, imovel);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Imovel")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
