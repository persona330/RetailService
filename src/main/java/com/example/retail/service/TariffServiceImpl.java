package com.example.retail.service;

import com.example.retail.mapper.ProducerMapper;
import com.example.retail.mapper.TariffMapper;
import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.model.dto.TariffDTO;
import com.example.retail.model.entity.Producer;
import com.example.retail.model.entity.Tariff;
import com.example.retail.repository.ProducerRepository;
import com.example.retail.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService
{
    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository, TariffMapper tariffMapper)
    {
        this.tariffRepository = tariffRepository;
        this.tariffMapper = tariffMapper;
    }

    @Override
    public TariffDTO create(TariffDTO tariffDTO)
    {
        return tariffMapper.toDTO(tariffRepository.save(tariffMapper.toEntity(tariffDTO)));
    }

    @Override
    public List<TariffDTO> readAll()
    {
        List<Tariff> tariffList = tariffRepository.findAll();
        return tariffMapper.listToDTO(tariffList);
    }

    @Override
    public TariffDTO read(Integer id)
    {
        Tariff tariff = tariffRepository.getById(id);
        return tariffMapper.toDTO(tariff);
    }

    @Override
    public TariffDTO update(TariffDTO tariffDTO, Integer id)
    {
        Tariff tariff = tariffRepository.getById(id);
        Tariff tarifftoEntity = tariffMapper.toEntity(tariffDTO);

        if (tariff != null)
        {
            if (tarifftoEntity.getId_Tariff() == null) tarifftoEntity.setId_Tariff(tariff.getId_Tariff());

            if (tarifftoEntity.getName() == null) tarifftoEntity.setName(tariff.getName());

            if (tarifftoEntity.getCost() == null) tarifftoEntity.setCost(tariff.getCost());

            if (tarifftoEntity.getDeviliryTime() == null) tarifftoEntity.setDeviliryTime(tariff.getDeviliryTime());

            return tariffMapper.toDTO(tariffRepository.save(tarifftoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Tariff tariff = tariffRepository.getOne(id);
        if (tariff != null)
        {
            tariffRepository.delete(tariff);
            return true;
        }
        else return false;
    }
}
