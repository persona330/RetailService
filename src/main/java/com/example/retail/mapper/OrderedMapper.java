package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrderedDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Ordered;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("ordered")
public class OrderedMapper extends BaseMapper<Ordered, OrderedDTO>
{
    @Autowired
    private ModelMapper mapper;

    public OrderedMapper() {
        super(Ordered.class, OrderedDTO.class);
    }

    @Override
    public Ordered toEntity(OrderedDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Ordered.class);
    }

    @Override
    public OrderedDTO toDTO(Ordered entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, OrderedDTO.class);
    }

    @Override
    public List<OrderedDTO> listToDTO(List<Ordered> list)
    {
        ArrayList<OrderedDTO> listD = new ArrayList<>();
        for (Ordered e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }
}
