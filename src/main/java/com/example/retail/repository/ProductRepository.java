package com.example.retail.repository;

import com.example.retail.model.entity.Import;
import com.example.retail.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository <Product, Integer>
{
    List<Product> findAll();
    Product getById(Integer id);
    void delete(Product product);
    Product getOne(Integer id);
}
