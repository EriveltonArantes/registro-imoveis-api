package com.registroimoveisapi.service;

import com.registroimoveisapi.dto.ProprietarioRequestDTO;
import com.registroimoveisapi.dto.ProprietarioResponseDTO;
import com.registroimoveisapi.exception.ResourceNotFoundException;
import com.registroimoveisapi.mapper.ProprietarioMapper;
import com.registroimoveisapi.model.Proprietario;
import com.registroimoveisapi.repository.ProprietarioRepository;
import com.registroimoveisapi.repository.ImovelRepository;
import com.registroimoveisapi.model.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository repository;

    @Autowired
    private ProprietarioMapper mapper;

    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional(readOnly = true)
    public List<ProprietarioResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProprietarioResponseDTO buscar(Long id) {
        Proprietario entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProprietarioResponseDTO criar(ProprietarioRequestDTO dto) {
        Proprietario entity = mapper.toEntity(dto);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Proprietario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProprietarioResponseDTO atualizar(Long id, ProprietarioRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Proprietario não encontrado com id: " + id);
        }
        Proprietario entity = mapper.toEntity(dto);
        entity.setId(id);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Proprietario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Proprietario não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
