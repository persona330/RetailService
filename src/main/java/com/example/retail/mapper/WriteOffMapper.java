package com.example.retail.mapper;

import com.example.retail.model.dto.ShelfDTO;
import com.example.retail.model.dto.WriteOffDTO;
import com.example.retail.model.entity.Shelf;
import com.example.retail.model.entity.WriteOff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, NomenclatureMapper.class})
public interface WriteOffMapper
{
    @Mappings({
            @Mapping(target = "product", source = "productDTO"),
            @Mapping(target = "nomenclature", source = "nomenclatureDTO")
    })
    WriteOff toEntity(WriteOffDTO dto);
    @Mappings({
            @Mapping(target = "productDTO", source = "product"),
            @Mapping(target = "nomenclatureDTO", source = "nomenclature")
    })
    WriteOffDTO toDTO(WriteOff entity);
    List<WriteOffDTO> listToDTO(List<WriteOff> entityList);
}
