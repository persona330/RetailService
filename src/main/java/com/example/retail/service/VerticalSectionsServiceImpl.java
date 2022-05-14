package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.VerticalSectionsMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.VerticalSectionsDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.VerticalSections;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.VerticalSectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerticalSectionsServiceImpl implements VerticalSectionsService
{
    private final VerticalSectionsRepository verticalSectionsRepository;
    private final VerticalSectionsMapper verticalSectionsMapper;

    @Autowired
    public VerticalSectionsServiceImpl(VerticalSectionsRepository verticalSectionsRepository, VerticalSectionsMapper verticalSectionsMapper)
    {
        this.verticalSectionsRepository = verticalSectionsRepository;
        this.verticalSectionsMapper = verticalSectionsMapper;
    }

    @Override
    public VerticalSectionsDTO create(VerticalSectionsDTO verticalSectionsDTO)
    {
        return verticalSectionsMapper.toDTO(verticalSectionsRepository.save(verticalSectionsMapper.toEntity(verticalSectionsDTO)));
    }

    @Override
    public List<VerticalSectionsDTO> readAll()
    {
        List<VerticalSections> addresses = verticalSectionsRepository.findAll();
        return verticalSectionsMapper.listToDTO(addresses);
    }

    @Override
    public VerticalSectionsDTO read(Integer id)
    {
        VerticalSections address = verticalSectionsRepository.getById(id);
        return verticalSectionsMapper.toDTO(address);
    }

    @Override
    public VerticalSectionsDTO update(VerticalSectionsDTO verticalSectionsDTO, Integer id)
    {
        VerticalSections verticalSections = verticalSectionsRepository.getById(id);
        VerticalSections verticalSectionstoEntity = verticalSectionsMapper.toEntity(verticalSectionsDTO);

        if (verticalSections != null)
        {
            if (verticalSectionstoEntity.getId_VerticalSections() == null) verticalSectionstoEntity.setId_VerticalSections(verticalSections.getId_VerticalSections());

            if (verticalSectionstoEntity.getNumber() == null) verticalSectionstoEntity.setNumber(verticalSections.getNumber());

            if (verticalSectionstoEntity.getSize() == null) verticalSectionstoEntity.setSize(verticalSections.getSize());

            if (verticalSectionstoEntity.getStillage() == null) verticalSectionstoEntity.setStillage(verticalSections.getStillage());

            return verticalSectionsMapper.toDTO(verticalSectionsRepository.save(verticalSectionstoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        VerticalSections verticalSections = verticalSectionsRepository.getOne(id);
        if (verticalSections != null)
        {
            verticalSectionsRepository.delete(verticalSections);
            return true;
        }
        else return false;
    }
}
