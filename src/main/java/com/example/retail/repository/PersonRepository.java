package com.example.retail.repository;

import com.example.retail.model.entity.Customer;
import com.example.retail.model.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends BaseRepository <Person, Integer>
{
    List<Person> findAll();
    Person getById(Integer id);
    void delete(Person person);
    Person getOne(Integer id);
}
