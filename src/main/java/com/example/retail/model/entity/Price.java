package com.example.retail.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Цена со свойствами <b>id_Price<b/>, <b>quantity<b/>, <b><b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRICE")
public class Price extends BaseEntity
{
    /** Свойство идентификатор стоимость товара за единицу измерения*/
    private Integer id_Price;
    /**Свойство количество единиц измерения*/
    private int quantity;
    /**Свойство единица измерения*/
    private Measurement measurement;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Price
     * @param quantity
     * @param measurement
     * @see  Price#Price()
     */
    public Price(Integer id_Price, int quantity, Measurement measurement)
    {
        this.id_Price = id_Price;
        this.quantity = quantity;
        this.measurement = measurement;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Price#Price(Integer, int, Measurement)
     */
    public Price() {}

    @Id
    @GeneratedValue(generator = "SQLPrice", strategy = GenerationType.AUTO)
    @Column(name = "ID_price", unique = true, nullable = false)
    public Integer getId_Price() { return id_Price; }
    public void setId_Price(Integer id_Price) { this.id_Price = id_Price; }

    @NonNull
    @Column(name = "Full_name")
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "Measurement")
    public Measurement getMeasurement() { return measurement; }
    public void setMeasurement(Measurement measurement) { this.measurement = measurement; }
}
