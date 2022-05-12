package com.example.retail.mapper;

import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MeasurementMapper.class)
public interface PriceMapper
{
    @Mapping(target = "measurement", source = "measurementDTO")
    Price toEntity(PriceDTO dto);
    @Mapping(target = "measurementDTO", source = "measurement")
    PriceDTO toDTO(Price entity);
    List<PriceDTO> listToDTO(List<Price> entityList);

}
