package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Класс Покупатель со свойствами <b>id_Customer<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity
{
    /** Свойство идентификатор покупателя*/
    private Integer id_Customer;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Customer
     * @see Customer#Customer()
     */
    public Customer(Integer id_Customer)
    {
        this.id_Customer = id_Customer;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Customer#Customer(Integer)
     */
    public Customer(){}

    @Id
    @GeneratedValue(generator = "SQLCustomer", strategy = GenerationType.AUTO)
    @Column(name = "ID_Customer", unique = true, nullable = false)
    public Integer getId_Customer() { return id_Customer; }
    public void setId_Customer(Integer id_Customer) { this.id_Customer = id_Customer; }
}
