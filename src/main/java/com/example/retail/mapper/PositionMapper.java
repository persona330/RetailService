package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.dto.PositionDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Measurement;
import com.example.retail.model.entity.Position;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PositionMapper
{
    Position toEntity(PositionDTO dto);
    PositionDTO toDTO(Position entity);
    List<PositionDTO> listToDTO(List<Position> entityList);
}
