package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CommunicationDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("communication")
public class CommunicationMapper extends BaseMapper<Communication, CommunicationDTO>
{
    @Autowired
    private ModelMapper mapper;

    public CommunicationMapper() {
        super(Communication.class, CommunicationDTO.class);
    }

    @Override
    public Communication toEntity(CommunicationDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Communication.class);
    }

    @Override
    public CommunicationDTO toDTO(Communication entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CommunicationDTO.class);
    }

    @Override
    public List<CommunicationDTO> listToDTO(List<Communication> list)
    {
        ArrayList<CommunicationDTO> listD = new ArrayList<>();
        for (Communication e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
