package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO extends BaseDTO
{
    /** Свойство идентификатор огранизации поставляемой товары*/
    private Integer id_Organization;
    /**Свойство название организации*/
    private String name;
    /** Свойство ИНН организации*/
    private String inn;
    /**Свойство КПП*/
    private String kpp;
    /**Свойство адрес*/
    private Address address;
    /**Свойство связь*/
    private Communication communication;

    public Integer getId_Organization() { return id_Organization; }
    public void setId_Organization(Integer id_Organization) { this.id_Organization = id_Organization; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInn() { return inn; }
    public void setInn(String inn) { this.inn = inn; }

    public String getKpp() { return kpp; }
    public void setKpp(String kpp) { this.kpp = kpp; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Communication getCommunication() { return communication; }
    public void setCommunication(Communication communication) { this.communication = communication; }
}
