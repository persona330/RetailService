package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends BaseDTO
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

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Communication getCommunication() { return communication; }
    public void setCommunication(Communication communication) { this.communication = communication; }
}
