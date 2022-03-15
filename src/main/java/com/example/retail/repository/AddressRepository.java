package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends BaseRepository <Address, Integer>
{
    List<Address> findAll();
    Address getById(Integer id);
    void delete(Address address);
    Address getOne(Integer id);

}
