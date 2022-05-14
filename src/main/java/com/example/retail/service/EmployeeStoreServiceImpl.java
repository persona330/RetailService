package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.EmployeeStoreMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.EmployeeStore;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.EmployeeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeStoreServiceImpl implements EmployeeStoreService
{
    private final EmployeeStoreRepository employeeStoreRepository;
    private final EmployeeStoreMapper employeeStoreMapper;

    @Autowired
    public EmployeeStoreServiceImpl(EmployeeStoreRepository employeeStoreRepository, EmployeeStoreMapper employeeStoreMapper)
    {
        this.employeeStoreRepository = employeeStoreRepository;
        this.employeeStoreMapper = employeeStoreMapper;
    }

    @Override
    public EmployeeStoreDTO create(EmployeeStoreDTO employeeStoreDTO)
    {
        return employeeStoreMapper.toDTO(employeeStoreRepository.save(employeeStoreMapper.toEntity(employeeStoreDTO)));
    }

    @Override
    public List<EmployeeStoreDTO> readAll()
    {
        List<EmployeeStore> employeeStoreList = employeeStoreRepository.findAll();
        return employeeStoreMapper.listToDTO(employeeStoreList);
    }

    @Override
    public EmployeeStoreDTO read(Integer id)
    {
        EmployeeStore employeeStore = employeeStoreRepository.getById(id);
        return employeeStoreMapper.toDTO(employeeStore);
    }

    @Override
    public EmployeeStoreDTO update(EmployeeStoreDTO employeeStoreDTO, Integer id)
    {
        EmployeeStore employeeStore = employeeStoreRepository.getById(id);
        EmployeeStore employeeStoretoEntity = employeeStoreMapper.toEntity(employeeStoreDTO);

        if (employeeStore != null)
        {
            if (employeeStoretoEntity.getId() == null) employeeStoretoEntity.setId(employeeStore.getId());

            if (employeeStoretoEntity.getSurname() == null) employeeStoretoEntity.setSurname(employeeStore.getSurname());

            if (employeeStoretoEntity.getName() == null) employeeStoretoEntity.setName(employeeStore.getName());

            if (employeeStoretoEntity.getPatronymic() == null) employeeStoretoEntity.setPatronymic(employeeStore.getPatronymic());

            if (!employeeStoretoEntity.isFree()) employeeStoretoEntity.setFree(employeeStore.isFree());

            if (employeeStoretoEntity.getAddress() == null) employeeStoretoEntity.setAddress(employeeStore.getAddress());

            if (employeeStoretoEntity.getCommunication() == null) employeeStoretoEntity.setCommunication(employeeStore.getCommunication());

            if (employeeStoretoEntity.getOrganization() == null) employeeStoretoEntity.setOrganization(employeeStore.getOrganization());

            if (employeeStoretoEntity.getPosition() == null) employeeStoretoEntity.setPosition(employeeStore.getPosition());

            if (employeeStoretoEntity.getStore() == null) employeeStoretoEntity.setStore(employeeStore.getStore());

            return employeeStoreMapper.toDTO(employeeStoreRepository.save(employeeStoretoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        EmployeeStore employeeStore = employeeStoreRepository.getOne(id);
        if (employeeStore != null)
        {
            employeeStoreRepository.delete(employeeStore);
            return true;
        }
        else return false;
    }
}
