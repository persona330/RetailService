package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.StoreMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StoreDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Store;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService
{
    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper)
    {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public StoreDTO create(StoreDTO addressDTO)
    {
        return storeMapper.toDTO(storeRepository.save(storeMapper.toEntity(addressDTO)));
    }

    @Override
    public List<StoreDTO> readAll()
    {
        List<Store> storeList = storeRepository.findAll();
        return storeMapper.listToDTO(storeList);
    }

    @Override
    public StoreDTO read(Integer id)
    {
        Store store = storeRepository.getById(id);
        return storeMapper.toDTO(store);
    }

    @Override
    public StoreDTO update(StoreDTO storeDTO, Integer id)
    {
        Store store = storeRepository.getById(id);
        Store storetoEntity = storeMapper.toEntity(storeDTO);

        if (store != null)
        {
            if (storetoEntity.getId_Store() == null) storetoEntity.setId_Store(store.getId_Store());

            if (storetoEntity.getName() == null) storetoEntity.setName(store.getName());

            if (storetoEntity.getTotalCapacity() == null) storetoEntity.setTotalCapacity(store.getTotalCapacity());

            if (storetoEntity.getAddress() == null) storetoEntity.setAddress(store.getAddress());

            if (storetoEntity.getOrganization() == null) storetoEntity.setOrganization(store.getOrganization());

            return storeMapper.toDTO(storeRepository.save(storetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Store store = storeRepository.getOne(id);
        if (store != null)
        {
            storeRepository.delete(store);
            return true;
        }
        else return false;
    }
}
