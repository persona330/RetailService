package com.example.retail.service;

import com.example.retail.mapper.CustomerMapper;
import com.example.retail.mapper.PersonMapper;
import com.example.retail.mapper.PriceMapper;
import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.model.dto.PersonDTO;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Customer;
import com.example.retail.model.entity.Person;
import com.example.retail.model.entity.Price;
import com.example.retail.repository.CustomerRepository;
import com.example.retail.repository.PersonRepository;
import com.example.retail.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService
{
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper)
    {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonDTO> readAll()
    {
        List<Person> personList = personRepository.findAll();
        return personMapper.listToDTO(personList);
    }

    @Override
    public PersonDTO read(Integer id)
    {
        Person person = personRepository.getById(id);
        return personMapper.toDTO(person);
    }

    @Override
    public boolean delete(Integer id)
    {
        Person person = personRepository.getOne(id);
        if (person != null)
        {
            personRepository.delete(person);
            return true;
        }
        else return false;
    }
}
