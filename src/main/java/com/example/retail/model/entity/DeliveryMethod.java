package com.example.retail.model.entity;


import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Метод доставки со свойствами <b>id_DeliveryMethod<b/>, <b>name<b/>, <b>cost<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "DELIVERY_METHOD")
public class DeliveryMethod extends BaseEntity
{
    /** Свойство идентификатор метода доставки*/
    private Integer id_DeliveryMethod;
    /** Свойство название*/
    private String name;
    /** Свойство стоимость*/
    private BigDecimal cost;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_DeliveryMethod
     * @param name
     * @param cost
     * @see DeliveryMethod#DeliveryMethod()
     */
    public DeliveryMethod(Integer id_DeliveryMethod, String name, BigDecimal cost)
    {
        this.id_DeliveryMethod = id_DeliveryMethod;
        this.name = name;
        this.cost = cost;
    }
    /**
     * Конструктор - создание нового объекта
     * @see DeliveryMethod#DeliveryMethod(Integer, String, BigDecimal)
     */
    public DeliveryMethod(){}

    @Id
    @GeneratedValue(generator = "SQLDeliveryMethod", strategy = GenerationType.AUTO)
    @Column(name = "ID_DeliveryMethod", unique = true, nullable = false)
    public Integer getId_DeliveryMethod() { return id_DeliveryMethod; }
    public void setId_DeliveryMethod(Integer id_DeliveryMethod) { this.id_DeliveryMethod = id_DeliveryMethod; }

    @Basic
    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Basic
    @NonNull
    @Column(name = "Cost", length = 10)
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
}
