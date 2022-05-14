package com.example.retail.service;

import com.example.retail.mapper.EmployeeMapper;
import com.example.retail.mapper.EmployeeStoreMapper;
import com.example.retail.model.dto.EmployeeDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.model.entity.Employee;
import com.example.retail.model.entity.EmployeeStore;
import com.example.retail.repository.EmployeeRepository;
import com.example.retail.repository.EmployeeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper)
    {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO)
    {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    @Override
    public List<EmployeeDTO> readAll()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.listToDTO(employeeList);
    }

    @Override
    public EmployeeDTO read(Integer id)
    {
        Employee employee = employeeRepository.getById(id);
        return employeeMapper.toDTO(employee);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO, Integer id)
    {
        Employee employee = employeeRepository.getById(id);
        Employee employeetoEntity = employeeMapper.toEntity(employeeDTO);

        if (employee != null)
        {
            if (employeetoEntity.getId() == null) employeetoEntity.setId(employee.getId());

            if (employeetoEntity.getSurname() == null) employeetoEntity.setSurname(employee.getSurname());

            if (employeetoEntity.getName() == null) employeetoEntity.setName(employee.getName());

            if (employeetoEntity.getPatronymic() == null) employeetoEntity.setPatronymic(employee.getPatronymic());

            if (!employeetoEntity.isFree()) employeetoEntity.setFree(employee.isFree());

            if (employeetoEntity.getAddress() == null) employeetoEntity.setAddress(employee.getAddress());

            if (employeetoEntity.getCommunication() == null) employeetoEntity.setCommunication(employee.getCommunication());

            if (employeetoEntity.getOrganization() == null) employeetoEntity.setOrganization(employee.getOrganization());

            return employeeMapper.toDTO(employeeRepository.save(employeetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Employee employee = employeeRepository.getOne(id);
        if (employee != null)
        {
            employeeRepository.delete(employee);
            return true;
        }
        else return false;
    }
}
