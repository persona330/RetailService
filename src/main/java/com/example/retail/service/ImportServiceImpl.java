package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.ImportMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ImportDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Import;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.ImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportServiceImpl implements ImportService
{
    private final ImportRepository importRepository;
    private final ImportMapper importMapper;

    @Autowired
    public ImportServiceImpl(ImportRepository importRepository, ImportMapper importMapper)
    {
        this.importRepository = importRepository;
        this.importMapper = importMapper;
    }

    @Override
    public ImportDTO create(ImportDTO importDTO)
    {
        return importMapper.toDTO(importRepository.save(importMapper.toEntity(importDTO)));
    }

    @Override
    public List<ImportDTO> readAll()
    {
        List<Import> importList = importRepository.findAll();
        return importMapper.listToDTO(importList);
    }

    @Override
    public ImportDTO read(Integer id)
    {
        Import anImport = importRepository.getById(id);
        return importMapper.toDTO(anImport);
    }

    @Override
    public ImportDTO update(ImportDTO importDTO, Integer id)
    {
        Import anImport = importRepository.getById(id);
        Import importtoEntity = importMapper.toEntity(importDTO);

        if (anImport != null)
        {
            if (importtoEntity.getId_Import() == null) importtoEntity.setId_Import(anImport.getId_Import());

            if (importtoEntity.getQuantity() == 0) importtoEntity.setQuantity(anImport.getQuantity());

            if (importtoEntity.getCost() == null) importtoEntity.setCost(anImport.getCost());

            if (importtoEntity.getVat() == 0) importtoEntity.setVat(anImport.getVat());

            if (importtoEntity.getConsignmentNote() == null) importtoEntity.setConsignmentNote(anImport.getConsignmentNote());

            if (importtoEntity.getNomenclature() == null) importtoEntity.setNomenclature(anImport.getNomenclature());

            return importMapper.toDTO(importRepository.save(importtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Import anImport = importRepository.getOne(id);
        if (anImport != null)
        {
            importRepository.delete(anImport);
            return true;
        }
        else return false;
    }
}
