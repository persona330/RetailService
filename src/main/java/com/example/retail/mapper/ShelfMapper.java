package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.ShelfDTO;
import com.example.retail.model.entity.Shelf;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, StillageMapper.class})
public interface ShelfMapper
{
    @Mappings({
            @Mapping(target = "group", source = "groupDTO"),
            @Mapping(target = "stillage", source = "stillageDTO")
    })
    Shelf toEntity(ShelfDTO dto);
    @Mappings({
            @Mapping(target = "groupDTO", source = "group"),
            @Mapping(target = "stillageDTO", source = "stillage")
    })
    ShelfDTO toDTO(Shelf entity);
    List<ShelfDTO> listToDTO(List<Shelf> entityList);
}
