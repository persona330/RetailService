package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Measurement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("measurement")
public class MeasurementMapper extends BaseMapper<Measurement, MeasurementDTO>
{
    @Autowired
    private ModelMapper mapper;

    public MeasurementMapper() {
        super(Measurement.class, MeasurementDTO.class);
    }

    @Override
    public Measurement toEntity(MeasurementDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Measurement.class);
    }

    @Override
    public MeasurementDTO toDTO(Measurement entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MeasurementDTO.class);
    }

    @Override
    public List<MeasurementDTO> listToDTO(List<Measurement> list)
    {
        ArrayList<MeasurementDTO> listD = new ArrayList<>();
        for (Measurement e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
