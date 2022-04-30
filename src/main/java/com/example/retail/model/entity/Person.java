package com.example.retail.model.entity;

/**
 * Класс Человек со свойствами <b>surname<b/>, <b>name<b/>, <b>patronymic<b/>
 */
public class Person
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

    public Person(String surname, String name, String patronymic, Address address, Communication communication)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.communication = communication;
    }

    public Person(){}

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Communication getCommunication() { return communication; }
    public void setCommunication(Communication communication) { this.communication = communication; }
}
