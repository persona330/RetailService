package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Producer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("producer")
public class ProducerMapper extends BaseMapper<Producer, ProducerDTO>
{
    @Autowired
    private ModelMapper mapper;

    public ProducerMapper() {
        super(Producer.class, ProducerDTO.class);
    }

    @Override
    public Producer toEntity(ProducerDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Producer.class);
    }

    @Override
    public ProducerDTO toDTO(Producer entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ProducerDTO.class);
    }

    @Override
    public List<ProducerDTO> listToDTO(List<Producer> list)
    {
        ArrayList<ProducerDTO> listD = new ArrayList<>();
        for (Producer e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
