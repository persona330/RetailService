package com.example.retail.mapper;

import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Measurement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper
{
    Measurement toEntity(MeasurementDTO dto);
    MeasurementDTO toDTO(Measurement entity);
}
