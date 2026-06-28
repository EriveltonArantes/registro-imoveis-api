package com.registroimoveisapi.mapper;

import com.registroimoveisapi.dto.CertidaoRequestDTO;
import com.registroimoveisapi.dto.CertidaoResponseDTO;
import com.registroimoveisapi.model.Certidao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertidaoMapper {

    @Mapping(target = "imovel", ignore = true)
    Certidao toEntity(CertidaoRequestDTO dto);

    @Mapping(target = "imovelId", source = "imovel.id")
    CertidaoResponseDTO toResponseDTO(Certidao entity);
}
