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
    private AddressDTO address;
    /**Свойство связь*/
    private CommunicationDTO communication;

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
    public AddressDTO getAddressDTO() { return address; }
    @Override
    public void setAddressDTO(AddressDTO address) { this.address = address; }

    @Override
    public CommunicationDTO getCommunicationDTO() { return communication; }
    @Override
    public void setCommunicationDTO(CommunicationDTO communication) { this.communication = communication; }

}
