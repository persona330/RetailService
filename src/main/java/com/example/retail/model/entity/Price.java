package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Класс Цена со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRICE")
//@Access(AccessType.PROPERTY)
public class Price extends BaseEntity
{
    /** Свойство идентификатор стоимость товара за единицу измерения*/
    private Integer id_PriceFor;
    /**Свойство количество единиц измерения*/
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "measurement")
    private Measurement measurement;

    public Price(Integer id_PriceFor, int quantity, Measurement measurement)
    {
        this.id_PriceFor = id_PriceFor;
        this.quantity = quantity;
        this.measurement = measurement;
    }
    public Price() {}
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