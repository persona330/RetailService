package com.example.retail.model.entity;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Человек со свойством <b>id<b/>
 */

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity
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
    private Address address;
    /**Свойство связь*/
    private Communication communication;

    public Person(Integer id, String surname, String name, String patronymic, Address address, Communication communication)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.communication = communication;
    }
    public Person(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }

    @NonNull
    @Column(name = "Surname")
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Value("Нет")
    @Column(name = "Patronymic")
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

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
