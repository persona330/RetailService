package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedServiceImpl implements OrderedService
{
    /** Хранилище товаров */
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper)
    {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO)
    {
        return addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(addressDTO)));
    }

    @Override
    public List<AddressDTO> readAll()
    {
        List<Address> addresses = addressRepository.findAll();
        return addressMapper.listToDTO(addresses);
    }

    @Override
    public AddressDTO read(Integer id)
    {
        Address address = addressRepository.getById(id);
        return addressMapper.toDTO(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, Integer id)
    {
        Address address = addressRepository.getById(id);
        Address addresstoEntity = addressMapper.toEntity(addressDTO);

        if (address != null)
        {
            if (addresstoEntity.getId_Address() == null) addresstoEntity.setId_Address(address.getId_Address());

            if (addresstoEntity.getApartment() == null) addresstoEntity.setApartment(address.getApartment());

            if (addresstoEntity.getEntrance() == 0) addresstoEntity.setEntrance(address.getEntrance());

            if (addresstoEntity.getHouse() == null) addresstoEntity.setHouse(address.getHouse());

            if (addresstoEntity.getStreet() == null) addresstoEntity.setStreet(address.getStreet());

            if (addresstoEntity.getRegion() == null) addresstoEntity.setRegion(address.getRegion());

            if (addresstoEntity.getCity() == null) addresstoEntity.setCity(address.getCity());

            if (addresstoEntity.getNation() == null) addresstoEntity.setNation(address.getNation());

            return addressMapper.toDTO(addressRepository.save(addresstoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Address address = addressRepository.getOne(id);
        if (address != null)
        {
            addressRepository.delete(address);
            return true;
        }
        else return false;
    }
}
