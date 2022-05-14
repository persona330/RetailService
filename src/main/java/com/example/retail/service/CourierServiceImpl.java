package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.CourierMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CourierDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Courier;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService
{
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository, CourierMapper courierMapper)
    {
        this.courierRepository = courierRepository;
        this.courierMapper = courierMapper;
    }

    @Override
    public CourierDTO create(CourierDTO courierDTO)
    {
        return courierMapper.toDTO(courierRepository.save(courierMapper.toEntity(courierDTO)));
    }

    @Override
    public List<CourierDTO> readAll()
    {
        List<Courier> courierList = courierRepository.findAll();
        return courierMapper.listToDTO(courierList);
    }

    @Override
    public CourierDTO read(Integer id)
    {
        Courier courier = courierRepository.getById(id);
        return courierMapper.toDTO(courier);
    }

    @Override
    public CourierDTO update(CourierDTO courierDTO, Integer id)
    {
        Courier courier = courierRepository.getById(id);
        Courier couriertoEntity = courierMapper.toEntity(courierDTO);

        if (courier != null)
        {
            if (couriertoEntity.getId() == null) couriertoEntity.setId(courier.getId());

            if (couriertoEntity.getSurname() == null) couriertoEntity.setSurname(courier.getSurname());

            if (couriertoEntity.getName() == null) couriertoEntity.setName(courier.getName());

            if (couriertoEntity.getPatronymic() == null) couriertoEntity.setPatronymic(courier.getPatronymic());

            if (couriertoEntity.getAddress() == null) couriertoEntity.setAddress(courier.getAddress());

            if (couriertoEntity.getCommunication() == null) couriertoEntity.setCommunication(courier.getCommunication());

            if (couriertoEntity.getOrganization() == null) couriertoEntity.setOrganization(courier.getOrganization());

            if (!couriertoEntity.isFree()) couriertoEntity.setFree(courier.isFree());

            if (couriertoEntity.getTransport() == null) couriertoEntity.setTransport(courier.getTransport());

            return courierMapper.toDTO(courierRepository.save(couriertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Courier courier = courierRepository.getOne(id);
        if (courier != null)
        {
            courierRepository.delete(courier);
            return true;
        }
        else return false;
    }
}
