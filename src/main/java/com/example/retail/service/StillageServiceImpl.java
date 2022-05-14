package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.StillageMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StillageDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Stillage;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.StillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StillageServiceImpl implements StillageService
{
    private final StillageRepository stillageRepository;
    private final StillageMapper stillageMapper;

    @Autowired
    public StillageServiceImpl(StillageRepository stillageRepository, StillageMapper stillageMapper)
    {
        this.stillageRepository = stillageRepository;
        this.stillageMapper = stillageMapper;
    }

    @Override
    public StillageDTO create(StillageDTO stillageDTO)
    {
        return stillageMapper.toDTO(stillageRepository.save(stillageMapper.toEntity(stillageDTO)));
    }

    @Override
    public List<StillageDTO> readAll()
    {
        List<Stillage> stillageList = stillageRepository.findAll();
        return stillageMapper.listToDTO(stillageList);
    }

    @Override
    public StillageDTO read(Integer id)
    {
        Stillage stillage = stillageRepository.getById(id);
        return stillageMapper.toDTO(stillage);
    }

    @Override
    public StillageDTO update(StillageDTO stillageDTO, Integer id)
    {
        Stillage stillage = stillageRepository.getById(id);
        Stillage stillagetoEntity = stillageMapper.toEntity(stillageDTO);

        if (stillage != null)
        {
            if (stillagetoEntity.getId_Stillage() == null) stillagetoEntity.setId_Stillage(stillage.getId_Stillage());

            if (stillagetoEntity.getNumber() == null) stillagetoEntity.setNumber(stillage.getNumber());

            if (stillagetoEntity.getSize() == null) stillagetoEntity.setSize(stillage.getSize());

            if (stillagetoEntity.getArea() == null) stillagetoEntity.setArea(stillage.getArea());

            return stillageMapper.toDTO(stillageRepository.save(stillagetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Stillage stillage = stillageRepository.getOne(id);
        if (stillage != null)
        {
            stillageRepository.delete(stillage);
            return true;
        }
        else return false;
    }
}
