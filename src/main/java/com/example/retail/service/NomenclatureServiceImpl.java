package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.NomenclatureMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.NomenclatureDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Nomenclature;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.NomenclatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomenclatureServiceImpl implements NomenclatureService
{
    private final NomenclatureRepository nomenclatureRepository;
    private final NomenclatureMapper nomenclatureMapper;

    @Autowired
    public NomenclatureServiceImpl(NomenclatureRepository nomenclatureRepository, NomenclatureMapper nomenclatureMapper)
    {
        this.nomenclatureRepository = nomenclatureRepository;
        this.nomenclatureMapper = nomenclatureMapper;
    }

    @Override
    public NomenclatureDTO create(NomenclatureDTO nomenclatureDTO)
    {
        return nomenclatureMapper.toDTO(nomenclatureRepository.save(nomenclatureMapper.toEntity(nomenclatureDTO)));
    }

    @Override
    public List<NomenclatureDTO> readAll()
    {
        List<Nomenclature> nomenclatureList = nomenclatureRepository.findAll();
        return nomenclatureMapper.listToDTO(nomenclatureList);
    }

    @Override
    public NomenclatureDTO read(Integer id)
    {
        Nomenclature nomenclature = nomenclatureRepository.getById(id);
        return nomenclatureMapper.toDTO(nomenclature);
    }

    @Override
    public NomenclatureDTO update(NomenclatureDTO nomenclatureDTO, Integer id)
    {
        Nomenclature nomenclature = nomenclatureRepository.getById(id);
        Nomenclature nomenclaturetoEntity = nomenclatureMapper.toEntity(nomenclatureDTO);

        if (nomenclature != null)
        {
            if (nomenclaturetoEntity.getId_Nomenclature() == null) nomenclaturetoEntity.setId_Nomenclature(nomenclature.getId_Nomenclature());

            if (nomenclaturetoEntity.getName() == null) nomenclaturetoEntity.setName(nomenclature.getName());

            if (nomenclaturetoEntity.getBrand() == null) nomenclaturetoEntity.setBrand(nomenclature.getBrand());

            if (nomenclaturetoEntity.getCost() == null) nomenclaturetoEntity.setCost(nomenclature.getCost());

            if (nomenclaturetoEntity.getProductionDate() == null) nomenclaturetoEntity.setProductionDate(nomenclature.getProductionDate());

            if (nomenclaturetoEntity.getExpirationDate() == null) nomenclaturetoEntity.setExpirationDate(nomenclature.getExpirationDate());

            if (nomenclaturetoEntity.getWeight() == null) nomenclaturetoEntity.setWeight(nomenclature.getWeight());

            if (nomenclaturetoEntity.getSize() == null) nomenclaturetoEntity.setSize(nomenclature.getSize());

            if (nomenclaturetoEntity.getOrganization() == null) nomenclaturetoEntity.setOrganization(nomenclature.getOrganization());

            if (nomenclaturetoEntity.getGroup() == null) nomenclaturetoEntity.setGroup(nomenclature.getGroup());

            if (nomenclaturetoEntity.getMeasurement() == null) nomenclaturetoEntity.setMeasurement(nomenclature.getMeasurement());

            if (nomenclaturetoEntity.getBox() == null) nomenclaturetoEntity.setBox(nomenclature.getBox());

            if (nomenclaturetoEntity.getStorageConditions() == null) nomenclaturetoEntity.setStorageConditions(nomenclature.getStorageConditions());

            if (nomenclaturetoEntity.getProduct() == null) nomenclaturetoEntity.setProduct(nomenclature.getProduct());

            return nomenclatureMapper.toDTO(nomenclatureRepository.save(nomenclaturetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Nomenclature nomenclature = nomenclatureRepository.getOne(id);
        if (nomenclature != null)
        {
            nomenclatureRepository.delete(nomenclature);
            return true;
        }
        else return false;
    }
}
