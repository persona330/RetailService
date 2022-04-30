package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс СпособОплаты со свойствами <b>id_PaymentMethod<b/>, <b>name<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PAYMENT_METHOD")
public class PaymentMethod extends BaseEntity
{
    /** Свойство идентификатор способа оплаты*/
    private Integer id_PaymentMethod;
    /**Свойство название*/
    private String name;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_PaymentMethod
     * @param name
     * @see PaymentMethod#PaymentMethod()
     */
    public PaymentMethod(Integer id_PaymentMethod, String name)
    {
        this.id_PaymentMethod = id_PaymentMethod;
        this.name = name;
    }
    /**
     * Конструктор - создание нового объекта
     * @see PaymentMethod#PaymentMethod(Integer, String)
     */
    public PaymentMethod(){}

    @Id
    @GeneratedValue(generator = "SQLPaymentMethod", strategy = GenerationType.AUTO)
    @Column(name = "ID_payment_method", unique = true, nullable = false)
    public Integer getId_PaymentMethod() { return id_PaymentMethod; }
    public void setId_PaymentMethod(Integer id_PaymentMethod) { this.id_PaymentMethod = id_PaymentMethod; }

    @Basic
    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
