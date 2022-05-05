package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.CommunicationMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CommunicationDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationServiceImpl implements CommunicationService
{
    /** Хранилище товаров */
    private final CommunicationRepository communicationRepository;
    private final CommunicationMapper communicationMapper;

    @Autowired
    public CommunicationServiceImpl(CommunicationRepository communicationRepository, CommunicationMapper communicationMapper)
    {
        this.communicationRepository = communicationRepository;
        this.communicationMapper = communicationMapper;
    }

    @Override
    public CommunicationDTO create(CommunicationDTO communicationDTO)
    {
        return communicationMapper.toDTO(communicationRepository.save(communicationMapper.toEntity(communicationDTO)));
    }

    @Override
    public List<CommunicationDTO> readAll()
    {
        List<Communication> addresses = communicationRepository.findAll();
        return communicationMapper.listToDTO(addresses);
    }

    @Override
    public CommunicationDTO read(Integer id)
    {
        Communication communication = communicationRepository.getById(id);
        return communicationMapper.toDTO(communication);
    }

    @Override
    public CommunicationDTO update(CommunicationDTO communicationDTO, Integer id)
    {
        Communication communication = communicationRepository.getById(id);
        Communication communicationtoEntity = communicationMapper.toEntity(communicationDTO);

        if (communication != null)
        {
            if (communicationtoEntity.getId_Communication() == null) communicationtoEntity.setId_Communication(communication.getId_Communication());

            if (communicationtoEntity.getPhone() == null) communicationtoEntity.setPhone(communication.getPhone());

            if (communicationtoEntity.getEmail() == null) communicationtoEntity.setEmail(communication.getEmail());

            return communicationMapper.toDTO(communicationRepository.save(communicationtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Communication communication = communicationRepository.getOne(id);
        if (communication != null)
        {
            communicationRepository.delete(communication);
            return true;
        }
        else return false;
    }
}
