package com.example.retail.mapper;

import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.model.dto.OrganizationDTO;
import com.example.retail.model.entity.EmployeeStore;
import com.example.retail.model.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PositionMapper.class, StoreMapper.class, AddressMapper.class, CommunicationMapper.class, OrganizationMapper.class})
public interface EmployeeStoreMapper
{
    @Mappings({
            @Mapping(target = "position", source = "positionDTO"),
            @Mapping(target = "store", source = "storeDTO"),
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO"),
            @Mapping(target = "organization", source = "organizationDTO")
    })
    EmployeeStore toEntity(EmployeeStoreDTO dto);
    @Mappings({
            @Mapping(target = "positionDTO", source = "position"),
            @Mapping(target = "storeDTO", source = "store"),
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication"),
            @Mapping(target = "organizationDTO", source = "organization")
    })
    EmployeeStoreDTO toDTO(EmployeeStore entity);
    List<EmployeeStoreDTO> listToDTO(List<EmployeeStore> entityList);
}
