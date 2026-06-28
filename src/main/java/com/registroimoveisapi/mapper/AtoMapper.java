package com.registroimoveisapi.mapper;

import com.registroimoveisapi.dto.AtoRequestDTO;
import com.registroimoveisapi.dto.AtoResponseDTO;
import com.registroimoveisapi.model.Ato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AtoMapper {

    @Mapping(target = "imovel", ignore = true)
    Ato toEntity(AtoRequestDTO dto);

    @Mapping(target = "imovelId", source = "imovel.id")
    AtoResponseDTO toResponseDTO(Ato entity);
}
