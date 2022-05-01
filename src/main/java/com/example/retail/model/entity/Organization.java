package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Организация со свойствами <b>id_Producer<b/>, <b>name<b/>, <b>iin<b/>, <b>kpp<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ORGANIZATION")
public class Organization extends BaseEntity
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

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Organization
     * @param name
     * @param inn
     * @param kpp
     * @see Organization#Organization()
     */
    public Organization(Integer id_Organization, String name, String inn, String kpp)
    {
        this.id_Organization = id_Organization;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Organization#Organization(Integer, String, String, String)
     */
    public Organization(){}

    @Id
    @GeneratedValue(generator = "SQLOrganization")
    @Column(name = "ID_organization", unique = true, nullable = false)
    public Integer getId_Organization() { return id_Organization; }
    public void setId_Organization(Integer id_Organization) { this.id_Organization = id_Organization; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "INN", length = 10)
    public String getInn() { return inn; }
    public void setInn(String inn) { this.inn = inn; }

    @NonNull
    @Column(name = "KPP", length = 9)
    public String getKpp() { return kpp; }
    public void setKpp(String kpp) { this.kpp = kpp; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Address")
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Communication")
    public Communication getCommunication() { return communication; }
    public void setCommunication(Communication communication) { this.communication = communication; }
}
