package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository extends BaseRepository <PaymentMethod, Integer>
{
    List<PaymentMethod> findAll();
    PaymentMethod getById(Integer id);
    void delete(PaymentMethod paymentMethod);
    PaymentMethod getOne(Integer id);
}
