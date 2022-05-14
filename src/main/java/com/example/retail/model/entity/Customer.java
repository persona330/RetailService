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
     * @param id
     * @param surname
     * @param name
     * @param patronymic
     * @param address
     * @param communication
     * @see Customer#Customer()
     */
    private Customer(Integer id, String surname, String name, String patronymic, Address address, Communication communication)
    {
        super(id, surname, name, patronymic, address, communication);
    }
    /**
     * Конструктор - создание нового объекта
     * @see Customer#Customer(Integer, String, String, String, Address, Communication)
     */
    public Customer(){super();}
}
