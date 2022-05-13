package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.NomenclatureDTO;
import com.example.retail.model.entity.Area;
import com.example.retail.model.entity.Nomenclature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProducerMapper.class, MeasurementMapper.class, BoxMapper.class,
        GroupMapper.class, StorageConditionsMapper.class, ProductMapper.class})
public interface NomenclatureMapper
{
    @Mappings({
            @Mapping(target = "producer", source = "producerDTO"),
            @Mapping(target = "measurement", source = "measurementDTO"),
            @Mapping(target = "box", source = "boxDTO"),
            @Mapping(target = "group", source = "groupDTO"),
            @Mapping(target = "storageConditions", source = "storageConditionsDTO"),
            @Mapping(target = "product", source = "productDTO")
    })
    Nomenclature toEntity(NomenclatureDTO dto);
    @Mappings({
            @Mapping(target = "producerDTO", source = "producer"),
            @Mapping(target = "measurementDTO", source = "measurement"),
            @Mapping(target = "boxDTO", source = "box"),
            @Mapping(target = "groupDTO", source = "group"),
            @Mapping(target = "storageConditionsDTO", source = "storageConditions"),
            @Mapping(target = "productDTO", source = "product")
    })
    NomenclatureDTO toDTO(Nomenclature entity);
    List<NomenclatureDTO> listToDTO(List<Nomenclature> entityList);
}
