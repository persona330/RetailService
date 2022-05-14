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
    public PersonDTO create(PersonDTO personDTO)
    {
        return personMapper.toDTO(personRepository.save(personMapper.toEntity(personDTO)));
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
    public PersonDTO update(PersonDTO personDTO, Integer id)
    {
        Person person = personRepository.getById(id);
        Person persontoEntity = personMapper.toEntity(personDTO);

        if (person != null)
        {
            if (persontoEntity.getId() == null) persontoEntity.setId(person.getId());

            if (persontoEntity.getSurname() == null) persontoEntity.setSurname(person.getSurname());

            if (persontoEntity.getName() == null) persontoEntity.setName(person.getName());

            if (persontoEntity.getPatronymic() == null) persontoEntity.setPatronymic(person.getPatronymic());

            if (persontoEntity.getAddress() == null) persontoEntity.setAddress(person.getAddress());

            if (persontoEntity.getCommunication() == null) persontoEntity.setCommunication(person.getCommunication());

            return personMapper.toDTO(personRepository.save(persontoEntity));
        }
        else return null;
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
