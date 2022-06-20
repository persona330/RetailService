package com.example.retail.mapper;

import com.example.retail.model.dto.GroupDTO;
import com.example.retail.model.entity.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper
{
    Group toEntity(GroupDTO dto);
    GroupDTO toDTO(Group entity);
    List<GroupDTO> listToDTO(List<Group> entityList);
}
