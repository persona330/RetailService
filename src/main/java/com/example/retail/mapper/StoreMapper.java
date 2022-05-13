package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.StoreDTO;
import com.example.retail.model.entity.Area;
import com.example.retail.model.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, OrganizationMapper.class})
public interface StoreMapper
{
    @Mappings({
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "organization", source = "organizationDTO")
    })
    Store toEntity(StoreDTO dto);
    @Mappings({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "organizationDTO", source = "organization")
    })
    StoreDTO toDTO(Store entity);
    List<StoreDTO> listToDTO(List<Store> entityList);
}
