package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component("address")
public class AddressMapper extends BaseMapper<Address, AddressDTO> {
    @Autowired
    private ModelMapper mapper;

    public AddressMapper() {
        super(Address.class, AddressDTO.class);
    }

    @Override
    public Address toEntity(AddressDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Address.class);
    }

    @Override
    public AddressDTO toDTO(Address entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> listToDTO(List<Address> list)
    {
        ArrayList<AddressDTO> listD = new ArrayList<>();
        for (Address e : list)
        {
            listD.add(toDTO(e));
        }
        return listD;
    }

}
