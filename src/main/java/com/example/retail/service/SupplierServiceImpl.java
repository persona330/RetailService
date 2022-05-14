package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.SupplierMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.SupplierDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Supplier;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService
{
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper)
    {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO)
    {
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Override
    public List<SupplierDTO> readAll()
    {
        List<Supplier> supplierList = supplierRepository.findAll();
        return supplierMapper.listToDTO(supplierList);
    }

    @Override
    public SupplierDTO read(Integer id)
    {
        Supplier supplier = supplierRepository.getById(id);
        return supplierMapper.toDTO(supplier);
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO, Integer id)
    {
        Supplier supplier = supplierRepository.getById(id);
        Supplier suppliertoEntity = supplierMapper.toEntity(supplierDTO);

        if (supplier != null)
        {
            if (suppliertoEntity.getId_Supplier() == null) suppliertoEntity.setId_Supplier(supplier.getId_Supplier());

            if (suppliertoEntity.getName() == null) suppliertoEntity.setName(supplier.getName());

            if (suppliertoEntity.getPosition() == null) suppliertoEntity.setPosition(supplier.getPosition());

            if (suppliertoEntity.getOrganization() == null) suppliertoEntity.setOrganization(supplier.getOrganization());

            return supplierMapper.toDTO(supplierRepository.save(suppliertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Supplier supplier = supplierRepository.getOne(id);
        if (supplier != null)
        {
            supplierRepository.delete(supplier);
            return true;
        }
        else return false;
    }
}
