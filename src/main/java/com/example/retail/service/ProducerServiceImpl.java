package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.ProducerMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Producer;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService
{
    /** Хранилище товаров */
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository, ProducerMapper producerMapper)
    {
        this.producerRepository = producerRepository;
        this.producerMapper = producerMapper;
    }

    @Override
    public ProducerDTO create(ProducerDTO producerDTO)
    {
        return producerMapper.toDTO(producerRepository.save(producerMapper.toEntity(producerDTO)));
    }

    @Override
    public List<ProducerDTO> readAll()
    {
        List<Producer> producerList = producerRepository.findAll();
        return producerMapper.listToDTO(producerList);
    }

    @Override
    public ProducerDTO read(Integer id)
    {
        Producer producer = producerRepository.getById(id);
        return producerMapper.toDTO(producer);
    }

    @Override
    public ProducerDTO update(ProducerDTO producerDTO, Integer id)
    {
        Producer producer = producerRepository.getById(id);
        Producer producertoEntity = producerMapper.toEntity(producerDTO);

        if (producer != null)
        {
            if (producertoEntity.getId_Producer() == null) producertoEntity.setId_Producer(producer.getId_Producer());

            if (producertoEntity.getName() == null) producertoEntity.setName(producer.getName());

            return producerMapper.toDTO(producerRepository.save(producertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Producer producer = producerRepository.getOne(id);
        if (producer != null)
        {
            producerRepository.delete(producer);
            return true;
        }
        else return false;
    }
}
