package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.GroupMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.GroupDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Group;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService
{
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository,GroupMapper groupMapper)
    {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupDTO create(GroupDTO groupDTO)
    {
        return groupMapper.toDTO(groupRepository.save(groupMapper.toEntity(groupDTO)));
    }

    @Override
    public List<GroupDTO> readAll()
    {
        List<Group> groupList = groupRepository.findAll();
        return groupMapper.listToDTO(groupList);
    }

    @Override
    public GroupDTO read(Integer id)
    {
        Group group = groupRepository.getById(id);
        return groupMapper.toDTO(group);
    }

    @Override
    public GroupDTO update(GroupDTO groupDTO, Integer id)
    {
        Group group = groupRepository.getById(id);
        Group grouptoEntity = groupMapper.toEntity(groupDTO);

        if (group != null)
        {
            if (grouptoEntity.getId_Group() == null) grouptoEntity.setId_Group(group.getId_Group());

            if (grouptoEntity.getName() == null) grouptoEntity.setName(group.getName());

            if (grouptoEntity.getType() == null) grouptoEntity.setType(group.getType());

            return groupMapper.toDTO(groupRepository.save(grouptoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Group group = groupRepository.getOne(id);
        if (group != null)
        {
            groupRepository.delete(group);
            return true;
        }
        else return false;
    }
}
