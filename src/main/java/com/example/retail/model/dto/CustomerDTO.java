package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends PersonDTO
{
    /** Свойство фамилия*/
    private String surname;
    /** Свойство имя*/
    private String name;
    /** Свойство отчество*/
    private String patronymic;
    /**Свойство адрес*/
    private Address address;
    /**Свойство связь*/
    private Communication communication;

    @Override
    public String getSurname() { return surname; }
    @Override
    public void setSurname(String surname) { this.surname = surname; }

    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getPatronymic() { return patronymic; }
    @Override
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    @Override
    public Address getAddress() { return address; }
    @Override
    public void setAddress(Address address) { this.address = address; }

    @Override
    public Communication getCommunication() { return communication; }
    @Override
    public void setCommunication(Communication communication) { this.communication = communication; }

}
