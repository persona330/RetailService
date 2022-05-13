package com.example.retail.mapper;

import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.model.entity.Customer;
import com.example.retail.model.entity.Producer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CommunicationMapper.class})
public interface CustomerMapper
{
    @Mappings({
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO")
    })
    Customer toEntity(CustomerDTO dto);
    @Mappings({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication")
    })
    CustomerDTO toDTO(Customer entity);
    List<CustomerDTO> listToDTO(List<Customer> entityList);
}
