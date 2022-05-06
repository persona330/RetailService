package com.example.retail.repository;

import com.example.retail.model.entity.CalculatedSign;
import com.example.retail.model.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository <Customer, Integer>
{
    List<Customer> findAll();
    Customer getById(Integer id);
    void delete(Customer customer);
    Customer getOne(Integer id);
}
