package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.ServiceCost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCostRepository extends BaseRepository <ServiceCost, Integer>
{
    List<ServiceCost> findAll();
    ServiceCost getById(Integer id);
    void delete(ServiceCost serviceCost);
    ServiceCost getOne(Integer id);
}
