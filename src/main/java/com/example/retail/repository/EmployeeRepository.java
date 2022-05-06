package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository <Employee, Integer>
{
    List<Employee> findAll();
    Employee getById(Integer id);
    void delete(Employee employee);
    Employee getOne(Integer id);
}
