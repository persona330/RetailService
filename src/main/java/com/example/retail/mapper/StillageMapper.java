package com.example.retail.mapper;

import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.dto.StillageDTO;
import com.example.retail.model.entity.Product;
import com.example.retail.model.entity.Stillage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = AreaMapper.class)
public interface StillageMapper
{
    @Mapping(target = "area", source = "areaDTO")
    Stillage toEntity(StillageDTO dto);
    @Mapping(target = "areaDTO", source = "area")
    StillageDTO toDTO(Stillage entity);
    List<StillageDTO> listToDTO(List<Stillage> entityList);
}
