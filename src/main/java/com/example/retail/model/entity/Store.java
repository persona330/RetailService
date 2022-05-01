package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Склад со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Store
{
    /** Свойство идентификатор склада*/
    private Integer id_Store;
    /**Свойство название*/
    private String name;
    /**Свойство общая вместимость*/
    private BigDecimal totalCapacity;

    private Address address;

    private Organization organization;

    public Store(Integer id_Store, String name, BigDecimal totalCapacity, Address address, Organization organization)
    {
        this.id_Store = id_Store;
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.address = address;
        this.organization = organization;
    }

    public Integer getId_Store() { return id_Store; }
    public void setId_Store(Integer id_Store) { this.id_Store = id_Store; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(BigDecimal totalCapacity) { this.totalCapacity = totalCapacity; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
