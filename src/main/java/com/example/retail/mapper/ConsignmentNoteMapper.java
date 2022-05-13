package com.example.retail.mapper;

import com.example.retail.model.dto.ConsignmentNoteDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.model.entity.ConsignmentNote;
import com.example.retail.model.entity.EmployeeStore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SupplierMapper.class, EmployeeStoreMapper.class})
public interface ConsignmentNoteMapper
{
    @Mappings({
            @Mapping(target = "supplier", source = "supplierDTO"),
            @Mapping(target = "employeeStore", source = "employeeStoreDTO")
    })
    ConsignmentNote toEntity(ConsignmentNoteDTO dto);
    @Mappings({
            @Mapping(target = "supplierDTO", source = "supplier"),
            @Mapping(target = "employeeStoreDTO", source = "employeeStore")
    })
    ConsignmentNoteDTO toDTO(ConsignmentNote entity);
    List<ConsignmentNoteDTO> listToDTO(List<ConsignmentNote> entityList);
}
