package com.registroimoveisapi.controller;

import com.registroimoveisapi.model.Imovel;
import com.registroimoveisapi.model.Proprietario;
import com.registroimoveisapi.model.Ato;
import com.registroimoveisapi.model.Certidao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.registroimoveisapi.repository.ImovelRepository imovelRepository;

    @Autowired
    private com.registroimoveisapi.repository.ProprietarioRepository proprietarioRepository;

    @Autowired
    private com.registroimoveisapi.repository.AtoRepository atoRepository;

    @Autowired
    private com.registroimoveisapi.repository.CertidaoRepository certidaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalImovel", imovelRepository.count());
        resumo.put("somaAreaImovel", imovelRepository.findAll().stream().filter(e -> e.getArea() != null).mapToDouble(e -> e.getArea()).sum());
        resumo.put("totalProprietario", proprietarioRepository.count());
        resumo.put("somaParticipacaoProprietario", proprietarioRepository.findAll().stream().filter(e -> e.getParticipacao() != null).mapToDouble(e -> e.getParticipacao()).sum());
        resumo.put("totalAto", atoRepository.count());
        resumo.put("somaValorAto", atoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoAto", atoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCertidao", certidaoRepository.count());
        resumo.put("graficoCertidao", certidaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
