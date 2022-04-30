package com.example.retail.model.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Адрес со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>, <b>house<b/>, <b>street<b/>,
 * <b>region<b/>, <b>city<b/>, <b>nation<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ADDRESS")
public class Address extends BaseEntity
{
    /** Свойство идентификатор адреса*/
    private Integer id_Address;
    /**Свойство номер квартиры*/
    private String apartment;
    /**Свойство номер подъезда*/
    private int entrance;
    /** Свойство номер дома*/
    private String house;
    /**Свойство название улицы*/
    private String street;
    /**Свойство название района*/
    private String region;
    /**Свойство наименование города*/
    private String city;
    /**Свойство наименование страны*/
    private String nation;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Address
     * @param apartment
     * @param entrance
     * @param house
     * @param street
     * @param region
     * @param city
     * @param nation
     * @see Address#Address()
     */
    public Address(Integer id_Address, String apartment, int entrance, String house, String street, String region, String city, String nation)
    {
        this.id_Address = id_Address;
        this.apartment = apartment;
        this.entrance = entrance;
        this.house = house;
        this.street = street;
        this.region = region;
        this.city = city;
        this.nation = nation;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Address#Address(Integer, String, int, String, String, String, String, String)
     */
    public Address() {}

    @Id
    @GeneratedValue(generator = "SQLAddress", strategy = GenerationType.AUTO)
    @Column(name = "ID_address", unique = true, nullable = false)
    public Integer getId_Address() { return id_Address; }
    public void setId_Address(Integer id_Address) { this.id_Address = id_Address; }

    @Value("1")
    @Column(name = "Apartment", length = 5)
    public String getApartment() { return apartment; }
    public void setApartment(String apartment) { this.apartment = apartment; }

    @Value("0")
    @Column(name = "Entrance", length = 3)
    public int getEntrance() { return entrance; }
    public void setEntrance(int entrance) { this.entrance = entrance; }

    @NonNull
    @Column(name = "House", length = 4)
    public String getHouse() { return house; }
    public void setHouse(String house) { this.house = house; }

    @NonNull
    @Column(name = "Street")
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    @Value("Нет")
    @Column(name = "Region")
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @NonNull
    @Column(name = "City")
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @NonNull
    @Column(name = "Nation")
    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }
}
