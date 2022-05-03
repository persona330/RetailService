package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Стеллаж со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "STILLAGE")
public class Stillage extends BaseEntity
{
    /** Свойство идентификатор стеллажа*/
    private Integer id_Stillage;
    /** Свойство номер*/
    private String number;
    /** Свойство вмещаемый объем*/
    private BigDecimal size;
    /** Свойство зона хранения*/
    private Area area;

    public Stillage(Integer id_Stillage, String number, BigDecimal size, Area area)
    {
        this.id_Stillage = id_Stillage;
        this.number = number;
        this.size = size;
        this.area = area;
    }
    public Stillage(){}

    @Id
    @GeneratedValue(generator = "SQLStillage", strategy = GenerationType.AUTO)
    @Column(name = "ID_stillage", unique = true, nullable = false)
    public Integer getId_Stillage() { return id_Stillage; }
    public void setId_Stillage(Integer id_Stillage) { this.id_Stillage = id_Stillage; }

    @NonNull
    @Column(name = "Number")
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @NonNull
    @Column(name = "Size")
    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Area")
    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }
}
