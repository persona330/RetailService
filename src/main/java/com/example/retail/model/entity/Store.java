package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Склад со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "STORE")
public class Store extends BaseEntity
{
    /** Свойство идентификатор склада*/
    private Integer id_Store;
    /**Свойство название*/
    private String name;
    /**Свойство общая вместимость*/
    private BigDecimal totalCapacity;
    /** Свойство адрес*/
    private Address address;
    /** Свойство организация*/
    private Organization organization;

    public Store(Integer id_Store, String name, BigDecimal totalCapacity, Address address, Organization organization)
    {
        this.id_Store = id_Store;
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.address = address;
        this.organization = organization;
    }
    public Store(){}

    @Id
    @GeneratedValue(generator = "SQLStore", strategy = GenerationType.AUTO)
    @Column(name = "ID_store", unique = true, nullable = false)
    public Integer getId_Store() { return id_Store; }
    public void setId_Store(Integer id_Store) { this.id_Store = id_Store; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Total_сapacity")
    public BigDecimal getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(BigDecimal totalCapacity) { this.totalCapacity = totalCapacity; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Address")
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
