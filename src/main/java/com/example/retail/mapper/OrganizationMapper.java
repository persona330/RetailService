package com.example.retail.mapper;

import com.example.retail.model.dto.OrganizationDTO;
import com.example.retail.model.dto.StoreDTO;
import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CommunicationMapper.class})
public interface OrganizationMapper
{
    @Mappings({
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO")
    })
    Organization toEntity(OrganizationDTO dto);
    @Mappings({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication")
    })
    OrganizationDTO toDTO(Organization entity);
    List<OrganizationDTO> listToDTO(List<Organization> entityList);
}
