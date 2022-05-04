package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Полка со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "SHELF")
public class Shelf extends BaseEntity
{
    /** Свойство идентификатор полки*/
    private Integer id_Shelf;
    /** Свойство вместимость*/
    private BigDecimal size;
    /** Свойство номер*/
    private String number;
    /** Свойство группа товаров*/
    private Group group;
    /** Свойство стеллаж*/
    private Stillage stillage;

    public Shelf(Integer id_Shelf, BigDecimal size, String number, Group group, Stillage stillage)
    {
        this.id_Shelf = id_Shelf;
        this.size = size;
        this.number = number;
        this.group = group;
        this.stillage = stillage;
    }
    public Shelf(){}

    @Id
    @GeneratedValue(generator = "SQLShelf", strategy = GenerationType.AUTO)
    @Column(name = "ID_shelf", unique = true, nullable = false)
    public Integer getId_Shelf() { return id_Shelf; }
    public void setId_Shelf(Integer id_Shelf) { this.id_Shelf = id_Shelf; }

    @NonNull
    @Column(name = "Size")
    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    @NonNull
    @Column(name = "Number")
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Product_group")
    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Stillage")
    public Stillage getStillage() { return stillage; }
    public void setStillage(Stillage stillage) { this.stillage = stillage; }
}
