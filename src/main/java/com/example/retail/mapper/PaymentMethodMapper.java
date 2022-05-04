package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PaymentMethodDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.PaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("payment_method")
public class PaymentMethodMapper extends BaseMapper<PaymentMethod, PaymentMethodDTO>
{
    @Autowired
    private ModelMapper mapper;

    public PaymentMethodMapper() {
        super(PaymentMethod.class, PaymentMethodDTO.class);
    }

    @Override
    public PaymentMethod toEntity(PaymentMethodDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, PaymentMethod.class);
    }

    @Override
    public PaymentMethodDTO toDTO(PaymentMethod entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PaymentMethodDTO.class);
    }

    @Override
    public List<PaymentMethodDTO> listToDTO(List<PaymentMethod> list)
    {
        ArrayList<PaymentMethodDTO> listD = new ArrayList<>();
        for (PaymentMethod e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }

}
