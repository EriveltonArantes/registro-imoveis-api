package com.registroimoveisapi.service;

import com.registroimoveisapi.dto.AtoRequestDTO;
import com.registroimoveisapi.dto.AtoResponseDTO;
import com.registroimoveisapi.exception.ResourceNotFoundException;
import com.registroimoveisapi.mapper.AtoMapper;
import com.registroimoveisapi.model.Ato;
import com.registroimoveisapi.repository.AtoRepository;
import com.registroimoveisapi.repository.ImovelRepository;
import com.registroimoveisapi.model.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AtoService {

    @Autowired
    private AtoRepository repository;

    @Autowired
    private AtoMapper mapper;

    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional(readOnly = true)
    public List<AtoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AtoResponseDTO buscar(Long id) {
        Ato entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ato não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AtoResponseDTO criar(AtoRequestDTO dto) {
        Ato entity = mapper.toEntity(dto);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Ato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AtoResponseDTO atualizar(Long id, AtoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ato não encontrado com id: " + id);
        }
        Ato entity = mapper.toEntity(dto);
        entity.setId(id);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Ato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ato não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
