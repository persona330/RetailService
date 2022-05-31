package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.StorageConditionsMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StorageConditionsDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.StorageConditions;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.StorageConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageConditionsServiceImpl  implements StorageConditionsService
{
    private final StorageConditionsRepository storageConditionsRepository;
    private final StorageConditionsMapper storageConditionsMapper;

    @Autowired
    public StorageConditionsServiceImpl(StorageConditionsRepository storageConditionsRepository, StorageConditionsMapper storageConditionsMapper)
    {
        this.storageConditionsRepository = storageConditionsRepository;
        this.storageConditionsMapper = storageConditionsMapper;
    }

    @Override
    public StorageConditionsDTO create(StorageConditionsDTO storageConditionsDTO)
    {
        return storageConditionsMapper.toDTO(storageConditionsRepository.save(storageConditionsMapper.toEntity(storageConditionsDTO)));
    }

    @Override
    public List<StorageConditionsDTO> readAll()
    {
        List<StorageConditions> storageConditionsList = storageConditionsRepository.findAll();
        return storageConditionsMapper.listToDTO(storageConditionsList);
    }

    @Override
    public StorageConditionsDTO read(Integer id)
    {
        StorageConditions storageConditions = storageConditionsRepository.getById(id);
        return storageConditionsMapper.toDTO(storageConditions);
    }

    @Override
    public StorageConditionsDTO update(StorageConditionsDTO addressDTO, Integer id)
    {
        StorageConditions storageConditions = storageConditionsRepository.getById(id);
        StorageConditions storageConditionstoEntity = storageConditionsMapper.toEntity(addressDTO);

        if (storageConditions != null)
        {
            if (storageConditionstoEntity.getId_StorageConditions() == null) storageConditionstoEntity.setId_StorageConditions(storageConditions.getId_StorageConditions());

            if (storageConditionstoEntity.getName() == null) storageConditionstoEntity.setName(storageConditions.getName());

            if (storageConditionstoEntity.getTemperature() == null) storageConditionstoEntity.setTemperature(storageConditions.getTemperature());

            if (storageConditionstoEntity.getHumidity() == null) storageConditionstoEntity.setHumidity(storageConditions.getHumidity());

            if (storageConditionstoEntity.getIllumination() == null) storageConditionstoEntity.setIllumination(storageConditions.getIllumination());

            if (storageConditionstoEntity.getMeasurementTemperature() == null) storageConditionstoEntity.setMeasurementTemperature(storageConditions.getMeasurementTemperature());

            if (storageConditionstoEntity.getMeasurementHumidity() == null) storageConditionstoEntity.setMeasurementHumidity(storageConditions.getMeasurementHumidity());

            if (storageConditionstoEntity.getMeasurementIllumination() == null) storageConditionstoEntity.setMeasurementIllumination(storageConditions.getMeasurementIllumination());

            return storageConditionsMapper.toDTO(storageConditionsRepository.save(storageConditionstoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        StorageConditions storageConditions = storageConditionsRepository.getOne(id);
        if (storageConditions != null)
        {
            storageConditionsRepository.delete(storageConditions);
            return true;
        }
        else return false;
    }
}
