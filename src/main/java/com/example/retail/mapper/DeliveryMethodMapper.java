package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.DeliveryMethod;
import com.example.retail.model.entity.Measurement;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface DeliveryMethodMapper
{
    DeliveryMethod toEntity(DeliveryMethodDTO dto);
    DeliveryMethodDTO toDTO(DeliveryMethod entity);
    List<DeliveryMethodDTO> listToDTO(List<DeliveryMethod> entityList);
}
