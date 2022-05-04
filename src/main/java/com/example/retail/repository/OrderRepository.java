package com.example.retail.repository;

import com.example.retail.model.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository <Order, Integer>
{
    List<Order> findAll();
    Order getById(Integer id);
    void delete(Order order);
    Order getOne(Integer id);
}
