package com.example.retail.mapper;

import com.example.retail.model.dto.OrderDTO;
import com.example.retail.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderedMapper.class, ProductMapper.class})
public interface OrderMapper
{
    @Mappings({
            @Mapping(target = "product", source = "productDTO"),
            @Mapping(target = "ordered", source = "orderedDTO")
    })
    Order toEntity(OrderDTO dto);
    @Mappings({
            @Mapping(target = "productDTO", source = "product"),
            @Mapping(target = "orderedDTO", source = "ordered")
    })
    OrderDTO toDTO(Order entity);
    List<OrderDTO> listToDTO(List<Order> entityList);
}
