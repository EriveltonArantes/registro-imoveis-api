package com.registroimoveisapi.service;

import com.registroimoveisapi.dto.ImovelRequestDTO;
import com.registroimoveisapi.dto.ImovelResponseDTO;
import com.registroimoveisapi.exception.ResourceNotFoundException;
import com.registroimoveisapi.mapper.ImovelMapper;
import com.registroimoveisapi.model.Imovel;
import com.registroimoveisapi.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    @Autowired
    private ImovelMapper mapper;

    @Transactional(readOnly = true)
    public List<ImovelResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ImovelResponseDTO buscar(Long id) {
        Imovel entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ImovelResponseDTO criar(ImovelRequestDTO dto) {
        Imovel entity = mapper.toEntity(dto);
        Imovel salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Imovel não encontrado com id: " + id);
        }
        Imovel entity = mapper.toEntity(dto);
        entity.setId(id);
        Imovel salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Imovel não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
