package com.example.retail.mapper;

import com.example.retail.model.dto.CourierDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.entity.Courier;
import com.example.retail.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TransportMapper.class, AddressMapper.class, CommunicationMapper.class, OrganizationMapper.class})
public interface CourierMapper
{
    @Mappings({
            @Mapping(target = "transport", source = "transportDTO"),
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO"),
            @Mapping(target = "organization", source = "organizationDTO")
    })
    Courier toEntity(CourierDTO dto);
    @Mappings({
            @Mapping(target = "transportDTO", source = "transport"),
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication"),
            @Mapping(target = "organizationDTO", source = "organization")
    })
    CourierDTO toDTO(Courier entity);
    List<CourierDTO> listToDTO(List<Courier> entityList);
}
