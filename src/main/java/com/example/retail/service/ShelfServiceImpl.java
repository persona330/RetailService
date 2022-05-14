package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.ShelfMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ShelfDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Shelf;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService
{
    private final ShelfRepository shelfRepository;
    private final ShelfMapper shelfMapper;

    @Autowired
    public ShelfServiceImpl(ShelfRepository shelfRepository, ShelfMapper shelfMapper)
    {
        this.shelfRepository = shelfRepository;
        this.shelfMapper = shelfMapper;
    }

    @Override
    public ShelfDTO create(ShelfDTO shelfDTO)
    {
        return shelfMapper.toDTO(shelfRepository.save(shelfMapper.toEntity(shelfDTO)));
    }

    @Override
    public List<ShelfDTO> readAll()
    {
        List<Shelf> shelfList = shelfRepository.findAll();
        return shelfMapper.listToDTO(shelfList);
    }

    @Override
    public ShelfDTO read(Integer id)
    {
        Shelf shelf = shelfRepository.getById(id);
        return shelfMapper.toDTO(shelf);
    }

    @Override
    public ShelfDTO update(ShelfDTO shelfDTO, Integer id)
    {
        Shelf shelf = shelfRepository.getById(id);
        Shelf shelftoEntity = shelfMapper.toEntity(shelfDTO);

        if (shelf != null)
        {
            if (shelftoEntity.getId_Shelf() == null) shelftoEntity.setId_Shelf(shelf.getId_Shelf());

            if (shelftoEntity.getSize() == null) shelftoEntity.setSize(shelf.getSize());

            if (shelftoEntity.getNumber() == null) shelftoEntity.setNumber(shelf.getNumber());

            if (shelftoEntity.getGroup() == null) shelftoEntity.setGroup(shelf.getGroup());

            if (shelftoEntity.getStillage() == null) shelftoEntity.setStillage(shelf.getStillage());

            return shelfMapper.toDTO(shelfRepository.save(shelftoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Shelf shelf = shelfRepository.getOne(id);
        if (shelf != null)
        {
            shelfRepository.delete(shelf);
            return true;
        }
        else return false;
    }
}
