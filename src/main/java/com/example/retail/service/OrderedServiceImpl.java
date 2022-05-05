package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.OrderedMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrderedDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Ordered;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.OrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedServiceImpl implements OrderedService
{
    /** Хранилище товаров */
    private final OrderedRepository orderedRepository;
    private final OrderedMapper orderedMapper;

    @Autowired
    public OrderedServiceImpl(OrderedRepository orderedRepository, OrderedMapper orderedMapperr)
    {
        this.orderedRepository = orderedRepository;
        this.orderedMapper = orderedMapperr;
    }

    @Override
    public OrderedDTO create(OrderedDTO addressDTO)
    {
        return orderedMapper.toDTO(orderedRepository.save(orderedMapper.toEntity(addressDTO)));
    }

    @Override
    public List<OrderedDTO> readAll()
    {
        List<Ordered> addresses = orderedRepository.findAll();
        return orderedMapper.listToDTO(addresses);
    }

    @Override
    public OrderedDTO read(Integer id)
    {
        Ordered address = orderedRepository.getById(id);
        return orderedMapper.toDTO(address);
    }

    @Override
    public OrderedDTO update(OrderedDTO addressDTO, Integer id)
    {
        Ordered ordered = orderedRepository.getById(id);
        Ordered orderedtoEntity = orderedMapper.toEntity(addressDTO);

        if (ordered != null)
        {
            if (orderedtoEntity.getId_Ordered() == null) orderedtoEntity.setId_Ordered(ordered.getId_Ordered());

            if (orderedtoEntity.getRegistrationDate() == null) orderedtoEntity.setRegistrationDate(ordered.getRegistrationDate());

            if (orderedtoEntity.getWeight() == null) orderedtoEntity.setWeight(ordered.getWeight());

            if (orderedtoEntity.getFullPrice() == null) orderedtoEntity.setFullPrice(ordered.getFullPrice());

            return orderedMapper.toDTO(orderedRepository.save(orderedtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Ordered address = orderedRepository.getOne(id);
        if (address != null)
        {
            orderedRepository.delete(address);
            return true;
        }
        else return false;
    }
}
