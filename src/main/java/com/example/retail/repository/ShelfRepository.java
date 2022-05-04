package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Shelf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfRepository extends BaseRepository <Shelf, Integer>
{
    List<Shelf> findAll();
    Shelf getById(Integer id);
    void delete(Shelf shelf);
    Shelf getOne(Integer id);
}
