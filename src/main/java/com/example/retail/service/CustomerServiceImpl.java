package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.CustomerMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Customer;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements  CustomerService
{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper)
    {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO)
    {
        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(customerDTO)));
    }

    @Override
    public List<CustomerDTO> readAll()
    {
        List<Customer> customerList = customerRepository.findAll();
        return customerMapper.listToDTO(customerList);
    }

    @Override
    public CustomerDTO read(Integer id)
    {
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO, Integer id)
    {
        Customer customer = customerRepository.getById(id);
        Customer customertoEntity = customerMapper.toEntity(customerDTO);

        if (customer != null)
        {
            if (customertoEntity.getId() == null) customertoEntity.setId(customer.getId());

            if (customertoEntity.getSurname() == null) customertoEntity.setSurname(customer.getSurname());

            if (customertoEntity.getName() == null) customertoEntity.setName(customer.getName());

            if (customertoEntity.getPatronymic() == null) customertoEntity.setPatronymic(customer.getPatronymic());

            if (customertoEntity.getAddress() == null) customertoEntity.setAddress(customer.getAddress());

            if (customertoEntity.getCommunication() == null) customertoEntity.setCommunication(customer.getCommunication());

            return customerMapper.toDTO(customerRepository.save(customertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Customer customer = customerRepository.getOne(id);
        if (customer != null)
        {
            customerRepository.delete(customer);
            return true;
        }
        else return false;
    }
}
