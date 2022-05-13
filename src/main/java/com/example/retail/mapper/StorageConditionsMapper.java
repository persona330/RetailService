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
            @Mapping(target = "measuremenTemperature", source = "measuremenTemperatureDTO"),
            @Mapping(target = "measuremenHumidity", source = "measuremenHumidityDTO"),
            @Mapping(target = "measuremenIllumination", source = "measuremenIlluminationDTO")
    })
    StorageConditions toEntity(StorageConditionsDTO dto);
    @Mappings({
            @Mapping(target = "measuremenTemperatureDTO", source = "measuremenTemperature"),
            @Mapping(target = "measuremenHumidityDTO", source = "measuremenHumidity"),
            @Mapping(target = "measuremenIlluminationDTO", source = "measuremenIllumination")
    })
    StorageConditionsDTO toDTO(StorageConditions entity);
    List<StorageConditionsDTO> listToDTO(List<StorageConditions> entityList);
}
