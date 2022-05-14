package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.AreaMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Area;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService
{
    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository, AreaMapper areaMapper)
    {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
    }

    @Override
    public AreaDTO create(AreaDTO areaDTO)
    {
        return areaMapper.toDTO(areaRepository.save(areaMapper.toEntity(areaDTO)));
    }

    @Override
    public List<AreaDTO> readAll()
    {
        List<Area> addresses = areaRepository.findAll();
        return areaMapper.listToDTO(addresses);
    }

    @Override
    public AreaDTO read(Integer id)
    {
        Area address = areaRepository.getById(id);
        return areaMapper.toDTO(address);
    }

    @Override
    public AreaDTO update(AreaDTO areaDTO, Integer id)
    {
        Area area = areaRepository.getById(id);
        Area areatoEntity = areaMapper.toEntity(areaDTO);

        if (area != null)
        {
            if (areatoEntity.getId_Area() == null) areatoEntity.setId_Area(area.getId_Area());

            if (areatoEntity.getName() == null) areatoEntity.setName(area.getName());

            if (areatoEntity.getCapacity() == null) areatoEntity.setCapacity(area.getCapacity());

            if (areatoEntity.getStorageConditions() == null) areatoEntity.setStorageConditions(area.getStorageConditions());

            if (areatoEntity.getStore() == null) areatoEntity.setStore(area.getStore());

            return areaMapper.toDTO(areaRepository.save(areatoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Area area = areaRepository.getOne(id);
        if (area != null)
        {
            areaRepository.delete(area);
            return true;
        }
        else return false;
    }
}
