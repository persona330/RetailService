package com.example.retail.mapper;

import com.example.retail.model.dto.OrganizationDTO;
import com.example.retail.model.dto.SupplierDTO;
import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrganizationMapper.class, PositionMapper.class})
public interface SupplierMapper
{
    @Mappings({
            @Mapping(target = "organization", source = "organizationDTO"),
            @Mapping(target = "position", source = "positionDTO")
    })
    Supplier toEntity(SupplierDTO dto);
    @Mappings({
            @Mapping(target = "organizationDTO", source = "organization"),
            @Mapping(target = "positionDTO", source = "position")
    })
    SupplierDTO toDTO(Supplier entity);
    List<SupplierDTO> listToDTO(List<Supplier> entityList);
}
