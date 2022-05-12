package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CalculatedSignDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.CalculatedSign;
import com.example.retail.model.entity.Measurement;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface CalculatedSignMapper
{
    CalculatedSign toEntity(CalculatedSignDTO dto);
    CalculatedSignDTO toDTO(CalculatedSign entity);
    List<CalculatedSignDTO> listToDTO(List<CalculatedSign> entityList);
}
