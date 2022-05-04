package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CalculatedSignDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.CalculatedSign;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("calculated_sign")
public class CalculatedSignMapper extends BaseMapper<CalculatedSign, CalculatedSignDTO>
{
    @Autowired
    private ModelMapper mapper;

    public CalculatedSignMapper() {
        super(CalculatedSign.class, CalculatedSignDTO.class);
    }

    @Override
    public CalculatedSign toEntity(CalculatedSignDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, CalculatedSign.class);
    }

    @Override
    public CalculatedSignDTO toDTO(CalculatedSign entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CalculatedSignDTO.class);
    }

    @Override
    public List<CalculatedSignDTO> listToDTO(List<CalculatedSign> list)
    {
        ArrayList<CalculatedSignDTO> listD = new ArrayList<>();
        for (CalculatedSign e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
