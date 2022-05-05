package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.DeliveryMethodMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.DeliveryMethod;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.DeliveryMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService
{
    /** Хранилище товаров */
    private final DeliveryMethodRepository deliveryMethodRepository;
    private final DeliveryMethodMapper deliveryMethodMapper;

    @Autowired
    public DeliveryMethodServiceImpl(DeliveryMethodRepository deliveryMethodRepository, DeliveryMethodMapper deliveryMethodMapper)
    {
        this.deliveryMethodRepository = deliveryMethodRepository;
        this.deliveryMethodMapper = deliveryMethodMapper;
    }

    @Override
    public DeliveryMethodDTO create(DeliveryMethodDTO deliveryMethodDTO)
    {
        return deliveryMethodMapper.toDTO(deliveryMethodRepository.save(deliveryMethodMapper.toEntity(deliveryMethodDTO)));
    }

    @Override
    public List<DeliveryMethodDTO> readAll()
    {
        List<DeliveryMethod> deliveryMethodList = deliveryMethodRepository.findAll();
        return deliveryMethodMapper.listToDTO(deliveryMethodList);
    }

    @Override
    public DeliveryMethodDTO read(Integer id)
    {
        DeliveryMethod deliveryMethod = deliveryMethodRepository.getById(id);
        return deliveryMethodMapper.toDTO(deliveryMethod);
    }

    @Override
    public DeliveryMethodDTO update(DeliveryMethodDTO deliveryMethodDTO, Integer id)
    {
        DeliveryMethod deliveryMethod = deliveryMethodRepository.getById(id);
        DeliveryMethod deliveryMethodtoEntity = deliveryMethodMapper.toEntity(deliveryMethodDTO);

        if (deliveryMethod != null)
        {
            if (deliveryMethodtoEntity.getId_DeliveryMethod() == null) deliveryMethodtoEntity.setId_DeliveryMethod(deliveryMethod.getId_DeliveryMethod());

            if (deliveryMethodtoEntity.getName() == null) deliveryMethodtoEntity.setName(deliveryMethod.getName());

            if (deliveryMethodtoEntity.getCost() == null) deliveryMethodtoEntity.setCost(deliveryMethod.getCost());

            return deliveryMethodMapper.toDTO(deliveryMethodRepository.save(deliveryMethodtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        DeliveryMethod deliveryMethod = deliveryMethodRepository.getOne(id);
        if (deliveryMethod != null)
        {
            deliveryMethodRepository.delete(deliveryMethod);
            return true;
        }
        else return false;
    }
}
