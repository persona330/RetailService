package com.example.retail.mapper;

import com.example.retail.model.dto.DeliveryDTO;
import com.example.retail.model.dto.ServiceCostDTO;
import com.example.retail.model.entity.Delivery;
import com.example.retail.model.entity.ServiceCost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderedMapper.class, DeliveryMapper.class, PaymentMethodMapper.class,
        CustomerMapper.class})
public interface ServiceCostMapper
{
    @Mappings({
            @Mapping(target = "ordered", source = "orderedDTO"),
            @Mapping(target = "delivery", source = "deliveryDTO"),
            @Mapping(target = "paymentMethod", source = "paymentMethodDTO"),
            @Mapping(target = "customer", source = "customerDTO")
    })
    ServiceCost toEntity(ServiceCostDTO dto);
    @Mappings({
            @Mapping(target = "orderedDTO", source = "ordered"),
            @Mapping(target = "deliveryDTO", source = "delivery"),
            @Mapping(target = "paymentMethodDTO", source = "paymentMethod"),
            @Mapping(target = "customerDTO", source = "customer")
    })
    ServiceCostDTO toDTO(ServiceCost entity);
    List<ServiceCostDTO> listToDTO(List<ServiceCost> entityList);
}
