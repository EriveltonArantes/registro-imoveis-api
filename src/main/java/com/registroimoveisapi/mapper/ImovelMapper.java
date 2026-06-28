package com.registroimoveisapi.mapper;

import com.registroimoveisapi.dto.ImovelRequestDTO;
import com.registroimoveisapi.dto.ImovelResponseDTO;
import com.registroimoveisapi.model.Imovel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

    Imovel toEntity(ImovelRequestDTO dto);

    ImovelResponseDTO toResponseDTO(Imovel entity);
}
