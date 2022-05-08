package com.example.retail.mapper;

import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Measurement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("measurement")
public class MeasurementMapperImpl implements MeasurementMapper
{
    @Override
    public Measurement toEntity(MeasurementDTO dto)
    {
        if (dto == null) return null;
        Measurement measurement = new Measurement();
        measurement.setId_Measurement(dto.getId_Measurement());
        measurement.setName(dto.getName());
        measurement.setFullName(dto.getFullName());
        return measurement;
    }

    @Override
    public MeasurementDTO toDTO(Measurement entity)
    {
        if (entity == null) return null;
        MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setId_Measurement(entity.getId_Measurement());
        measurementDTO.setName(entity.getName());
        measurementDTO.setFullName(entity.getFullName());
        return measurementDTO;
    }

    public List<MeasurementDTO> listToDTO(List<Measurement> list)
    {
        ArrayList<MeasurementDTO> listDTO = new ArrayList<>();
        for (Measurement e : list)
        {
            listDTO.add(toDTO(e));
        }
        return listDTO;
    }
}
