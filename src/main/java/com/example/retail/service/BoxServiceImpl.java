package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.BoxMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.BoxDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Box;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService
{
    private final BoxRepository boxRepository;
    private final BoxMapper boxMapper;

    @Autowired
    public BoxServiceImpl(BoxRepository boxRepository, BoxMapper boxMapper)
    {
        this.boxRepository = boxRepository;
        this.boxMapper = boxMapper;
    }

    @Override
    public BoxDTO create(BoxDTO addressDTO)
    {
        return boxMapper.toDTO(boxRepository.save(boxMapper.toEntity(addressDTO)));
    }

    @Override
    public List<BoxDTO> readAll()
    {
        List<Box> boxList = boxRepository.findAll();
        return boxMapper.listToDTO(boxList);
    }

    @Override
    public BoxDTO read(Integer id)
    {
        Box box = boxRepository.getById(id);
        return boxMapper.toDTO(box);
    }

    @Override
    public BoxDTO update(BoxDTO boxDTO, Integer id)
    {
        Box box = boxRepository.getById(id);
        Box boxtoEntity = boxMapper.toEntity(boxDTO);

        if (box != null)
        {
            if (boxtoEntity.getId_Box() == null) boxtoEntity.setId_Box(box.getId_Box());

            if (boxtoEntity.getNumber() == null) boxtoEntity.setNumber(box.getNumber());

            if (boxtoEntity.getSize() == null) boxtoEntity.setSize(box.getSize());

            if (boxtoEntity.getShelf() == null) boxtoEntity.setShelf(box.getShelf());

            if (boxtoEntity.getVerticalSections() == null) boxtoEntity.setVerticalSections(box.getVerticalSections());

            return boxMapper.toDTO(boxRepository.save(boxtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Box box = boxRepository.getOne(id);
        if (box != null)
        {
            boxRepository.delete(box);
            return true;
        }
        else return false;
    }
}
