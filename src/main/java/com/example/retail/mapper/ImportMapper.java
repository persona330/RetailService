package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.ImportDTO;
import com.example.retail.model.entity.Area;
import com.example.retail.model.entity.Import;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NomenclatureMapper.class, ConsignmentNoteMapper.class})
public interface ImportMapper
{
    @Mappings({
            @Mapping(target = "nomenclature", source = "nomenclatureDTO"),
            @Mapping(target = "consignmentNote", source = "consignmentNoteDTO")
    })
    Import toEntity(ImportDTO dto);
    @Mappings({
            @Mapping(target = "nomenclatureDTO", source = "nomenclature"),
            @Mapping(target = "consignmentNoteDTO", source = "consignmentNote")
    })
    ImportDTO toDTO(Import entity);
    List<ImportDTO> listToDTO(List<Import> entityList);
}
