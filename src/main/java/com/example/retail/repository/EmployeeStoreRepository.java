package com.example.retail.repository;

import com.example.retail.model.entity.EmployeeStore;
import com.example.retail.model.entity.Measurement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeStoreRepository extends BaseRepository <EmployeeStore, Integer>
{
    List<EmployeeStore> findAll();
    EmployeeStore getById(Integer id);
    void delete(EmployeeStore employeeStore);
    EmployeeStore getOne(Integer id);
}
