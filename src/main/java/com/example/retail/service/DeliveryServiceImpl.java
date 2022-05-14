package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.DeliveryMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Delivery;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService
{
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper)
    {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public DeliveryDTO create(DeliveryDTO deliveryDTO)
    {
        return deliveryMapper.toDTO(deliveryRepository.save(deliveryMapper.toEntity(deliveryDTO)));
    }

    @Override
    public List<DeliveryDTO> readAll()
    {
        List<Delivery> deliveryList = deliveryRepository.findAll();
        return deliveryMapper.listToDTO(deliveryList);
    }

    @Override
    public DeliveryDTO read(Integer id)
    {
        Delivery delivery = deliveryRepository.getById(id);
        return deliveryMapper.toDTO(delivery);
    }

    @Override
    public DeliveryDTO update(DeliveryDTO deliveryDTO, Integer id)
    {
        Delivery delivery = deliveryRepository.getById(id);
        Delivery deliverytoEntity = deliveryMapper.toEntity(deliveryDTO);

        if (delivery != null)
        {
            if (deliverytoEntity.getId_Delivery() == null) deliverytoEntity.setId_Delivery(delivery.getId_Delivery());

            if (deliverytoEntity.getDate() == null) deliverytoEntity.setDate(delivery.getDate());

            if (deliverytoEntity.getTime() == null) deliverytoEntity.setTime(delivery.getTime());

            if (deliverytoEntity.getTotalCost() == null) deliverytoEntity.setTotalCost(delivery.getTotalCost());

            if (deliverytoEntity.getTotalSize() == null) deliverytoEntity.setTotalSize(delivery.getTotalSize());

            if (deliverytoEntity.getTotalWeight() == null) deliverytoEntity.setTotalWeight(delivery.getTotalWeight());

            if (deliverytoEntity.getDistanceFromAddressee() == null) deliverytoEntity.setDistanceFromAddressee(delivery.getDistanceFromAddressee());

            if (deliverytoEntity.getDeliveryMethod() == null) deliverytoEntity.setDeliveryMethod(delivery.getDeliveryMethod());

            if (deliverytoEntity.getTariff() == null) deliverytoEntity.setTariff(delivery.getTariff());

            if (deliverytoEntity.getTransport() == null) deliverytoEntity.setTransport(delivery.getTransport());

            if (deliverytoEntity.getAddress() == null) deliverytoEntity.setAddress(delivery.getAddress());

            return deliveryMapper.toDTO(deliveryRepository.save(deliverytoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Delivery delivery = deliveryRepository.getOne(id);
        if (delivery != null)
        {
            deliveryRepository.delete(delivery);
            return true;
        }
        else return false;
    }
}
