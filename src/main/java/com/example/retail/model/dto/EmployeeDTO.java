package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class EmployeeDTO extends PersonDTO
{
    /** Свойство идентификатор сотрудника*/
    private Integer id;
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

    public Integer get_Id(){ return id; }
    public void set_Id(Integer id){ this.id = id; }

    public String getSurname(){ return surname; }
    public void setSurname(String surname){ this.surname = surname;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic(){ return patronymic; }
    public void setPatronymic(String patronymic){ this.patronymic = patronymic; }

    public Address getAddress(){ return address; }
    public void setAddress(Address address){ this.address = address; }

    public Communication getCommunication(){ return communication; }
    public void setCommunication(Communication communication){ this.communication = communication; }

    public abstract boolean isFree();
    public abstract void setFree(boolean free);

    public abstract Organization getOrganization();
    public abstract void setOrganization(Organization organization);
}
