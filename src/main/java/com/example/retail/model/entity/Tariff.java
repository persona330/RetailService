package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Класс Тариф со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "TARIFF")
public class Tariff extends BaseEntity
{
    /** Свойство идентификатор тариф*/
    private Integer id_Tariff;
    /** Свойство название*/
    private String name;
    /** Свойство цена*/
    private BigDecimal cost;
    /** Свойство время доставки*/
    private Time deviliryTime;

    public Tariff(Integer id_Tariff, String name, BigDecimal cost, Time deviliryTime)
    {
        this.id_Tariff = id_Tariff;
        this.name = name;
        this.cost = cost;
        this.deviliryTime = deviliryTime;
    }
    public Tariff(){}

    @Id
    @GeneratedValue(generator = "SQLTariff", strategy = GenerationType.AUTO)
    @Column(name = "ID_tariff", unique = true, nullable = false)
    public Integer getId_Tariff() { return id_Tariff; }
    public void setId_Tariff(Integer id_Tariff) { this.id_Tariff = id_Tariff; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Cost")
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    @Temporal(TemporalType.TIME)
    @NonNull
    @Column(name = "Deviliry_time")
    public Time getDeviliryTime() { return deviliryTime; }
    public void setDeviliryTime(Time deviliryTime) { this.deviliryTime = deviliryTime; }
}
