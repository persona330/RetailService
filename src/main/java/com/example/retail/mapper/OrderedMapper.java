package com.example.retail.mapper;

import com.example.retail.model.dto.OrderedDTO;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Ordered;
import com.example.retail.model.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderedMapper
{
    Ordered toEntity(OrderedDTO dto);
    OrderedDTO toDTO(Ordered entity);
    List<OrderedDTO> listToDTO(List<Ordered> entityList);
}
