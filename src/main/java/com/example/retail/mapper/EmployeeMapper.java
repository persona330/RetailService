package com.example.retail.mapper;

import com.example.retail.model.dto.EmployeeDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.model.entity.Employee;
import com.example.retail.model.entity.EmployeeStore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CommunicationMapper.class, OrganizationMapper.class})
public interface EmployeeMapper
{
    @Mappings({
            @Mapping(target = "address", source = "addressDTO"),
            @Mapping(target = "communication", source = "communicationDTO"),
            @Mapping(target = "organization", source = "organizationDTO")
    })
    Employee toEntity(EmployeeDTO dto);
    @Mappings({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "communicationDTO", source = "communication"),
            @Mapping(target = "organizationDTO", source = "organization")
    })
    EmployeeDTO toDTO(Employee entity);
    List<EmployeeDTO> listToDTO(List<Employee> entityList);
}
