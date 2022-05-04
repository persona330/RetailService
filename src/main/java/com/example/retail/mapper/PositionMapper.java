package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PositionDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Position;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("position")
public class PositionMapper extends BaseMapper<Position, PositionDTO>
{
    @Autowired
    private ModelMapper mapper;

    public PositionMapper() {
        super(Position.class, PositionDTO.class);
    }

    @Override
    public Position toEntity(PositionDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Position.class);
    }

    @Override
    public PositionDTO toDTO(Position entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PositionDTO.class);
    }

    @Override
    public List<PositionDTO> listToDTO(List<Position> list)
    {
        ArrayList<PositionDTO> listD = new ArrayList<>();
        for (Position e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
