package com.example.retail.mapper;

import com.example.retail.model.dto.TariffDTO;
import com.example.retail.model.dto.TransportDTO;
import com.example.retail.model.entity.Tariff;
import com.example.retail.model.entity.Transport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffMapper
{
    Tariff toEntity(TariffDTO dto);
    TariffDTO toDTO(Tariff entity);
    List<TariffDTO> listToDTO(List<Tariff> entityList);
}
