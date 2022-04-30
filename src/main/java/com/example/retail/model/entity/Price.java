package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Цена со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRICE")
public class Price extends BaseEntity
{
    /** Свойство идентификатор стоимость товара за единицу измерения*/
    private Integer id_PriceFor;
    /**Свойство количество единиц измерения*/
    private int quantity;
    /**Свойство единица измерения*/
    private Measurement measurement;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_PriceFor
     * @param quantity
     * @param measurement
     * @see  Price#Price()
     */
    public Price(Integer id_PriceFor, int quantity, Measurement measurement)
    {
        this.id_PriceFor = id_PriceFor;
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
    public Integer getId_PriceFor() { return id_PriceFor; }
    public void setId_PriceFor(Integer id_PriceFor) { this.id_PriceFor = id_PriceFor; }

    @Basic
    @NonNull
    @Column(name = "Full_name")
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Measurement")
    public Measurement getMeasurement() { return measurement; }
    public void setMeasurement(Measurement measurement) { this.measurement = measurement; }
}

//@Access(AccessType.FIELD)
//    @OneToMany(mappedBy = "adresse", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//@Type(type = "text")
//    @ManyToMany(mappedBy = "spezialisierungen", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @Table(name = "DIENSTSTELLE")
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "ARZT_REGAL", joinColumns = @JoinColumn(name = "ID_Arzt", nullable = false), inverseJoinColumns = @JoinColumn(name = "ID_Regal"))
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "Dienststelle", nullable = false)
//    @OneToOne(mappedBy = "dokument", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)