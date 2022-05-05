package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.CalculatedSignMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CalculatedSignDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.CalculatedSign;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.CalculatedSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatedSignServiceImpl implements CalculatedSignService
{
    /** Хранилище товаров */
    private final CalculatedSignRepository calculatedSignRepository;
    private final CalculatedSignMapper calculatedSignMapper;

    @Autowired
    public CalculatedSignServiceImpl(CalculatedSignRepository calculatedSignRepository, CalculatedSignMapper calculatedSignMapper)
    {
        this.calculatedSignRepository = calculatedSignRepository;
        this.calculatedSignMapper = calculatedSignMapper;
    }

    @Override
    public CalculatedSignDTO create(CalculatedSignDTO calculatedSignDTO)
    {
        return calculatedSignMapper.toDTO(calculatedSignRepository.save(calculatedSignMapper.toEntity(calculatedSignDTO)));
    }

    @Override
    public List<CalculatedSignDTO> readAll()
    {
        List<CalculatedSign> calculatedSignList = calculatedSignRepository.findAll();
        return calculatedSignMapper.listToDTO(calculatedSignList);
    }

    @Override
    public CalculatedSignDTO read(Integer id)
    {
        CalculatedSign calculatedSign = calculatedSignRepository.getById(id);
        return calculatedSignMapper.toDTO(calculatedSign);
    }

    @Override
    public CalculatedSignDTO update(CalculatedSignDTO calculatedSignDTO, Integer id)
    {
        CalculatedSign calculatedSign = calculatedSignRepository.getById(id);
        CalculatedSign calculatedSigntoEntity = calculatedSignMapper.toEntity(calculatedSignDTO);

        if (calculatedSign != null)
        {
            if (calculatedSigntoEntity.getId_CalculatedSign() == null) calculatedSigntoEntity.setId_CalculatedSign(calculatedSign.getId_CalculatedSign());

            if (calculatedSigntoEntity.getName() == null) calculatedSigntoEntity.setName(calculatedSign.getName());

            return calculatedSignMapper.toDTO(calculatedSignRepository.save(calculatedSigntoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        CalculatedSign calculatedSign = calculatedSignRepository.getOne(id);
        if (calculatedSign != null)
        {
            calculatedSignRepository.delete(calculatedSign);
            return true;
        }
        else return false;
    }
}
