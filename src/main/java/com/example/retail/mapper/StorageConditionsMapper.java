package com.example.retail.mapper;

import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.dto.StorageConditionsDTO;
import com.example.retail.model.entity.Product;
import com.example.retail.model.entity.StorageConditions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = MeasurementMapper.class)
public interface StorageConditionsMapper
{
    @Mappings({
            @Mapping(target = "measurementTemperature", source = "measurementTemperatureDTO"),
            @Mapping(target = "measurementHumidity", source = "measurementHumidityDTO"),
            @Mapping(target = "measurementIllumination", source = "measurementIlluminationDTO")
    })
    StorageConditions toEntity(StorageConditionsDTO dto);
    @Mappings({
            @Mapping(target = "measurementTemperatureDTO", source = "measurementTemperature"),
            @Mapping(target = "measurementHumidityDTO", source = "measurementHumidity"),
            @Mapping(target = "measurementIlluminationDTO", source = "measurementIllumination")
    })
    StorageConditionsDTO toDTO(StorageConditions entity);
    List<StorageConditionsDTO> listToDTO(List<StorageConditions> entityList);
}
