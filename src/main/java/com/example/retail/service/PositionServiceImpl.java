package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.PositionMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PositionDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Position;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService
{
    /** Хранилище товаров */
    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper)
    {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public PositionDTO create(PositionDTO positionDTO)
    {
        return positionMapper.toDTO(positionRepository.save(positionMapper.toEntity(positionDTO)));
    }

    @Override
    public List<PositionDTO> readAll()
    {
        List<Position> addresses = positionRepository.findAll();
        return positionMapper.listToDTO(addresses);
    }

    @Override
    public PositionDTO read(Integer id)
    {
        Position position = positionRepository.getById(id);
        return positionMapper.toDTO(position);
    }

    @Override
    public PositionDTO update(PositionDTO positionDTO, Integer id)
    {
        Position position = positionRepository.getById(id);
        Position positiontoEntity = positionMapper.toEntity(positionDTO);

        if (position != null)
        {
            if (positiontoEntity.getId_Position() == null) positiontoEntity.setId_Position(position.getId_Position());

            if (positiontoEntity.getName() == null) positiontoEntity.setName(position.getName());

            return positionMapper.toDTO(positionRepository.save(positiontoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Position position = positionRepository.getOne(id);
        if (position != null)
        {
            positionRepository.delete(position);
            return true;
        }
        else return false;
    }
}
