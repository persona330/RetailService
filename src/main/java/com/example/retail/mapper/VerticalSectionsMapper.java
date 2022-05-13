package com.example.retail.mapper;

import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.dto.VerticalSectionsDTO;
import com.example.retail.model.entity.Product;
import com.example.retail.model.entity.VerticalSections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = StillageMapper.class)
public interface VerticalSectionsMapper
{
    @Mapping(target = "stillage", source = "stillageDTO")
    VerticalSections toEntity(VerticalSectionsDTO dto);
    @Mapping(target = "stillageDTO", source = "stillage")
    VerticalSectionsDTO toDTO(VerticalSections entity);
    List<VerticalSectionsDTO> listToDTO(List<VerticalSections> entityList);
}
