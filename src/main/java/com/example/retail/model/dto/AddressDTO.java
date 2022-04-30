package com.example.retail.model.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends BaseDTO
{
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

    public Integer getId_Address() { return id_Address; }
    public void setId_Address(Integer id_Address) { this.id_Address = id_Address; }

    public String getApartment() { return apartment; }
    public void setApartment(String apartment) { this.apartment = apartment; }

    public int getEntrance() { return entrance; }
    public void setEntrance(int entrance) { this.entrance = entrance; }

    public String getHouse() { return house; }
    public void setHouse(String house) { this.house = house; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }
}
