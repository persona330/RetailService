package com.example.retail.mapper;

import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MeasurementMapper.class)
public interface PriceMapper
{
    Price toEntity(PriceDTO dto);
    PriceDTO toDTO(Price entity);

}
