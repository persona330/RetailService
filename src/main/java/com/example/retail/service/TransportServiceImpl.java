package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.TransportMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.TransportDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Transport;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService
{
    /** Хранилище товаров */
    private final TransportRepository transportRepository;
    private final TransportMapper transportMapper;

    @Autowired
    public TransportServiceImpl(TransportRepository transportRepository, TransportMapper transportMapper)
    {
        this.transportRepository = transportRepository;
        this.transportMapper = transportMapper;
    }

    @Override
    public TransportDTO create(TransportDTO transportDTO)
    {
        return transportMapper.toDTO(transportRepository.save(transportMapper.toEntity(transportDTO)));
    }

    @Override
    public List<TransportDTO> readAll()
    {
        List<Transport> transportList = transportRepository.findAll();
        return transportMapper.listToDTO(transportList);
    }

    @Override
    public TransportDTO read(Integer id)
    {
        Transport transport = transportRepository.getById(id);
        return transportMapper.toDTO(transport);
    }

    @Override
    public TransportDTO update(TransportDTO transportDTO, Integer id)
    {
        Transport transport = transportRepository.getById(id);
        Transport transporttoEntity = transportMapper.toEntity(transportDTO);

        if (transport != null)
        {
            if (transporttoEntity.getId_Transport() == null) transporttoEntity.setId_Transport(transport.getId_Transport());

            if (transporttoEntity.getName() == null) transporttoEntity.setName(transport.getName());

            if (transporttoEntity.getCarryingCapacity() == null) transporttoEntity.setCarryingCapacity(transport.getCarryingCapacity());

            return transportMapper.toDTO(transportRepository.save(transporttoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Transport transport = transportRepository.getOne(id);
        if (transport != null)
        {
            transportRepository.delete(transport);
            return true;
        }
        else return false;
    }
}
