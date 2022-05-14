package com.example.retail.mapper;

import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.dto.PersonDTO;
import com.example.retail.model.entity.Customer;
import com.example.retail.model.entity.Measurement;
import com.example.retail.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CommunicationMapper.class})
public interface PersonMapper
{
    @Mappings({
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO")
    })
    Person toEntity(PersonDTO dto);
    @Mappings({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication")
    })
    PersonDTO toDTO(Person entity);
    List<PersonDTO> listToDTO(List<Person> entityList);
}
