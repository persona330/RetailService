package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends BaseDTO
{
    /** Свойство идентификатор человека*/
    private Integer id;
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

    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public AddressDTO getAddressDTO() { return address; }
    public void setAddressDTO(AddressDTO address) { this.address = address; }

    public CommunicationDTO getCommunicationDTO() { return communication; }
    public void setCommunicationDTO(CommunicationDTO communication) { this.communication = communication; }
}
