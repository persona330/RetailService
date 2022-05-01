package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Транспорт со свойствами <b>id_Customer<b/>, <b>name<b/>, <b>carryingCapacity<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "TRANSPORT")
public class Transport
{
    /** Свойство идентификатор транспорта*/
    private Integer id_Transport;
    /** Свойство название*/
    private String name;
    /** Свойство грузоподъемность*/
    private BigDecimal carryingCapacity;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Transport
     * @param name
     * @param carryingCapacity
     * @see Transport#Transport()
     */
    public Transport(Integer id_Transport, String name, BigDecimal carryingCapacity)
    {
        this.id_Transport = id_Transport;
        this.name = name;
        this.carryingCapacity = carryingCapacity;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Transport#Transport(Integer, String, BigDecimal)
     */
    public Transport(){}

    @Id
    @GeneratedValue(generator = "SQLTransport", strategy = GenerationType.AUTO)
    @Column(name = "ID_transport", unique = true, nullable = false)
    public Integer getId_Transport() { return id_Transport; }
    public void setId_Transport(Integer id_Transport) { this.id_Transport = id_Transport; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Carrying_capacity")
    public BigDecimal getCarryingCapacity() { return carryingCapacity; }
    public void setCarryingCapacity(BigDecimal carryingCapacity) { this.carryingCapacity = carryingCapacity; }
}
