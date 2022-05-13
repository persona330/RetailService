package com.example.retail.mapper;

import com.example.retail.model.dto.DeliveryDTO;
import com.example.retail.model.dto.NomenclatureDTO;
import com.example.retail.model.entity.Delivery;
import com.example.retail.model.entity.Nomenclature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TariffMapper.class, TransportMapper.class, DeliveryMethodMapper.class,
        AddressMapper.class})
public interface DeliveryMapper
{
    @Mappings({
            @Mapping(target = "tariff", source = "tariffDTO"),
            @Mapping(target = "transport", source = "transportDTO"),
            @Mapping(target = "deliveryMethod", source = "deliveryMethodDTO"),
            @Mapping(target = "address", source = "addressDTO")
    })
    Delivery toEntity(DeliveryDTO dto);
    @Mappings({
            @Mapping(target = "tariffDTO", source = "tariff"),
            @Mapping(target = "transportDTO", source = "transport"),
            @Mapping(target = "deliveryMethodDTO", source = "deliveryMethod"),
            @Mapping(target = "addressDTO", source = "address")
    })
    DeliveryDTO toDTO(Delivery entity);
    List<DeliveryDTO> listToDTO(List<Delivery> entityList);
}
