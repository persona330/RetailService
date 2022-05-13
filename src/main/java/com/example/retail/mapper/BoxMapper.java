package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.BoxDTO;
import com.example.retail.model.entity.Area;
import com.example.retail.model.entity.Box;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShelfMapper.class, VerticalSectionsMapper.class})
public interface BoxMapper
{
    @Mappings({
            @Mapping(target = "shelf", source = "shelfDTO"),
            @Mapping(target = "verticalSections", source = "verticalSectionsDTO")
    })
    Box toEntity(BoxDTO dto);
    @Mappings({
            @Mapping(target = "shelfDTO", source = "shelf"),
            @Mapping(target = "verticalSectionsDTO", source = "verticalSections")
    })
    BoxDTO toDTO(Box entity);
    List<BoxDTO> listToDTO(List<Box> entityList);
}
