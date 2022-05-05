package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.MeasurementMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Measurement;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService
{
    /** Хранилище товаров */
    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper)
    {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
    }

    @Override
    public MeasurementDTO create(MeasurementDTO measurementDTO)
    {
        return measurementMapper.toDTO(measurementRepository.save(measurementMapper.toEntity(measurementDTO)));
    }

    @Override
    public List<MeasurementDTO> readAll()
    {
        List<Measurement> addresses = measurementRepository.findAll();
        return measurementMapper.listToDTO(addresses);
    }

    @Override
    public MeasurementDTO read(Integer id)
    {
        Measurement measurement = measurementRepository.getById(id);
        return measurementMapper.toDTO(measurement);
    }

    @Override
    public MeasurementDTO update(MeasurementDTO measurementDTO, Integer id)
    {
        Measurement measurement = measurementRepository.getById(id);
        Measurement measurementtoEntity = measurementMapper.toEntity(measurementDTO);

        if (measurement != null)
        {
            if (measurementtoEntity.getId_Measurement() == null) measurementtoEntity.setId_Measurement(measurement.getId_Measurement());

            if (measurementtoEntity.getName() == null) measurementtoEntity.setName(measurement.getName());

            if (measurementtoEntity.getFullName() == null) measurementtoEntity.setFullName(measurement.getFullName());

            return measurementMapper.toDTO(measurementRepository.save(measurementtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Measurement measurement = measurementRepository.getOne(id);
        if (measurement != null)
        {
            measurementRepository.delete(measurement);
            return true;
        }
        else return false;
    }
}
