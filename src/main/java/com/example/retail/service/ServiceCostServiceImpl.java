package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.ServiceCostMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ServiceCostDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.ServiceCost;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.ServiceCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCostServiceImpl implements ServiceCostService
{
    private final ServiceCostRepository serviceCostRepository;
    private final ServiceCostMapper serviceCostMapper;

    @Autowired
    public ServiceCostServiceImpl(ServiceCostRepository serviceCostRepository, ServiceCostMapper serviceCostMapper)
    {
        this.serviceCostRepository = serviceCostRepository;
        this.serviceCostMapper = serviceCostMapper;
    }

    @Override
    public ServiceCostDTO create(ServiceCostDTO serviceCostDTO)
    {
        return serviceCostMapper.toDTO(serviceCostRepository.save(serviceCostMapper.toEntity(serviceCostDTO)));
    }

    @Override
    public List<ServiceCostDTO> readAll()
    {
        List<ServiceCost> serviceCostList = serviceCostRepository.findAll();
        return serviceCostMapper.listToDTO(serviceCostList);
    }

    @Override
    public ServiceCostDTO read(Integer id)
    {
        ServiceCost serviceCost = serviceCostRepository.getById(id);
        return serviceCostMapper.toDTO(serviceCost);
    }

    @Override
    public ServiceCostDTO update(ServiceCostDTO serviceCostDTO, Integer id)
    {
        ServiceCost serviceCost = serviceCostRepository.getById(id);
        ServiceCost serviceCosttoEntity = serviceCostMapper.toEntity(serviceCostDTO);

        if (serviceCost != null)
        {
            if (serviceCosttoEntity.getId_ServiceCost() == null) serviceCosttoEntity.setId_ServiceCost(serviceCost.getId_ServiceCost());

            if (serviceCosttoEntity.getFullCost() == null) serviceCosttoEntity.setFullCost(serviceCost.getFullCost());

            if (!serviceCosttoEntity.isPaidForBy()) serviceCosttoEntity.setPaidForBy(serviceCost.isPaidForBy());

            if (serviceCosttoEntity.getOrdered() == null) serviceCosttoEntity.setOrdered(serviceCost.getOrdered());

            if (serviceCosttoEntity.getDelivery() == null) serviceCosttoEntity.setDelivery(serviceCost.getDelivery());

            if (serviceCosttoEntity.getPaymentMethod() == null) serviceCosttoEntity.setPaymentMethod(serviceCost.getPaymentMethod());

            if (serviceCosttoEntity.getCustomer() == null) serviceCosttoEntity.setCustomer(serviceCost.getCustomer());

            return serviceCostMapper.toDTO(serviceCostRepository.save(serviceCosttoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        ServiceCost serviceCost = serviceCostRepository.getOne(id);
        if (serviceCost != null)
        {
            serviceCostRepository.delete(serviceCost);
            return true;
        }
        else return false;
    }
}
