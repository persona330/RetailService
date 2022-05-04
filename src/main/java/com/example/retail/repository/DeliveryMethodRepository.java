package com.example.retail.repository;

import com.example.retail.model.entity.ConsignmentNote;
import com.example.retail.model.entity.DeliveryMethod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryMethodRepository extends BaseRepository <DeliveryMethod, Integer>
{
    List<DeliveryMethod> findAll();
    DeliveryMethod getById(Integer id);
    void delete(DeliveryMethod deliveryMethod);
    DeliveryMethod getOne(Integer id);
}
