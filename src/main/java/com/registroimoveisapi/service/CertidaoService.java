package com.registroimoveisapi.service;

import com.registroimoveisapi.dto.CertidaoRequestDTO;
import com.registroimoveisapi.dto.CertidaoResponseDTO;
import com.registroimoveisapi.exception.ResourceNotFoundException;
import com.registroimoveisapi.mapper.CertidaoMapper;
import com.registroimoveisapi.model.Certidao;
import com.registroimoveisapi.repository.CertidaoRepository;
import com.registroimoveisapi.repository.ImovelRepository;
import com.registroimoveisapi.model.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CertidaoService {

    @Autowired
    private CertidaoRepository repository;

    @Autowired
    private CertidaoMapper mapper;

    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional(readOnly = true)
    public List<CertidaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CertidaoResponseDTO buscar(Long id) {
        Certidao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Certidao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CertidaoResponseDTO criar(CertidaoRequestDTO dto) {
        Certidao entity = mapper.toEntity(dto);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Certidao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CertidaoResponseDTO atualizar(Long id, CertidaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Certidao não encontrado com id: " + id);
        }
        Certidao entity = mapper.toEntity(dto);
        entity.setId(id);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Certidao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Certidao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
