package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Measurement;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AddressMapper
{
    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);
    List<AddressDTO> listToDTO(List<Address> entityList);
}
