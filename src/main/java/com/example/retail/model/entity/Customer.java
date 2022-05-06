package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Покупатель со свойствами <b>id_Customer<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn(name = "Id_customer")
public class Customer extends Person
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

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param surname
     * @param name
     * @param patronymic
     * @param address
     * @param communication
     * @see Customer#Customer()
     */
    private Customer(String surname, String name, String patronymic, Address address, Communication communication)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.communication = communication;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Customer#Customer(String, String, String, Address, Communication)
     */
    public Customer(){}

    @NonNull
    @Column(name = "Surname")
    @Override
    public String getSurname() { return surname; }
    @Override
    public void setSurname(String surname) { this.surname = surname; }

    @NonNull
    @Column(name = "Name")
    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }

    @Value("Нет")
    @Column(name = "Patronymic")
    @Override
    public String getPatronymic() { return patronymic; }
    @Override
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Address")
    @Override
    public Address getAddress() { return address; }
    @Override
    public void setAddress(Address address) { this.address = address; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Communication")
    @Override
    public Communication getCommunication() { return communication; }
    @Override
    public void setCommunication(Communication communication) { this.communication = communication; }
}
