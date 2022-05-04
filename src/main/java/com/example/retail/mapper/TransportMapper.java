package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.TransportDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Transport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("transport")
public class TransportMapper extends BaseMapper<Transport, TransportDTO>
{
    @Autowired
    private ModelMapper mapper;

    public TransportMapper() {
        super(Transport.class, TransportDTO.class);
    }

    @Override
    public Transport toEntity(TransportDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Transport.class);
    }

    @Override
    public TransportDTO toDTO(Transport entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TransportDTO.class);
    }

    @Override
    public List<TransportDTO> listToDTO(List<Transport> list)
    {
        ArrayList<TransportDTO> listD = new ArrayList<>();
        for (Transport e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }

}
