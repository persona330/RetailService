package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/*public enum Status
{

}*/

/**
 * Класс Заказано со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ORDERED")
public class Ordered extends BaseEntity
{
    /** Свойство идентификатор адреса*/
    private Integer id_Ordered;
    /**Свойство дата оформления заказа*/
    private Date registrationDate;
    /**Свойство вес заказанных товаров*/
    private BigDecimal weight;
    /** Свойство полная стоимость*/
    private BigDecimal fullPrice;
   // /**Свойство статус*/
    //private Status status;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Ordered
     * @param registrationDate
     * @param weight
     * @param fullPrice
     * @see Ordered#Ordered()
     */
    public Ordered(Integer id_Ordered, Date registrationDate, BigDecimal weight, BigDecimal fullPrice)
    {
        this.id_Ordered = id_Ordered;
        this.registrationDate = registrationDate;
        this.weight = weight;
        this.fullPrice = fullPrice;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Ordered#Ordered(Integer, Date, BigDecimal, BigDecimal)
     */
    public Ordered(){}

    @Id
    @GeneratedValue(generator = "SQLOrdered", strategy = GenerationType.AUTO)
    @Column(name = "ID_ordered", unique = true, nullable = false)
    public Integer getId_Ordered() { return id_Ordered; }
    public void setId_Ordered(Integer id_Ordered) { this.id_Ordered = id_Ordered; }

    @NonNull
   // @Temporal(TemporalType.DATE)
    @Column(name = "Registration_date", length = 10)
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    @NonNull
    @Column(name = "Weight")
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    @NonNull
    @Column(name = "Full_price")
    public BigDecimal getFullPrice() { return fullPrice; }
    public void setFullPrice(BigDecimal fullPrice) { this.fullPrice = fullPrice; }
}
