package com.registroimoveisapi.mapper;

import com.registroimoveisapi.dto.ProprietarioRequestDTO;
import com.registroimoveisapi.dto.ProprietarioResponseDTO;
import com.registroimoveisapi.model.Proprietario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProprietarioMapper {

    @Mapping(target = "imovel", ignore = true)
    Proprietario toEntity(ProprietarioRequestDTO dto);

    @Mapping(target = "imovelId", source = "imovel.id")
    ProprietarioResponseDTO toResponseDTO(Proprietario entity);
}
