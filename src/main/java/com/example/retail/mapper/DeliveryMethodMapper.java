package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.DeliveryMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("delivery_method")
public class DeliveryMethodMapper extends BaseMapper<DeliveryMethod, DeliveryMethodDTO>
{
    @Autowired
    private ModelMapper mapper;

    public DeliveryMethodMapper() { super(DeliveryMethod.class, DeliveryMethodDTO.class); }

    @Override
    public DeliveryMethod toEntity(DeliveryMethodDTO dto)
    {
        return Objects.isNull(dto) ? null : mapper.map(dto, DeliveryMethod.class);
    }

    @Override
    public DeliveryMethodDTO toDTO(DeliveryMethod entity)
    {
        return Objects.isNull(entity) ? null : mapper.map(entity, DeliveryMethodDTO.class);
    }

    @Override
    public List<DeliveryMethodDTO> listToDTO(List<DeliveryMethod> list)
    {
        ArrayList<DeliveryMethodDTO> listD = new ArrayList<>();
        for (DeliveryMethod e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }

}
