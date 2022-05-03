package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс ВертикальнаяСекция со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "VERTICAL_SECTIONS")
public class VerticalSections extends BaseEntity
{
    /** Свойство идентификатор вертикальной секции*/
    private Integer id_VerticalSections;
    /** Свойство номер*/
    private String number;
    /** Свойство вместимость*/
    private BigDecimal size;
    /** Свойство стеллаж*/
    private Stillage stillage;

    public VerticalSections(Integer id_VerticalSections, String number, BigDecimal size, Stillage stillage)
    {
        this.id_VerticalSections = id_VerticalSections;
        this.number = number;
        this.size = size;
        this.stillage = stillage;
    }
    public VerticalSections(){}

    @Id
    @GeneratedValue(generator = "SQLVerticalSections", strategy = GenerationType.AUTO)
    @Column(name = "ID_vertical_sections", unique = true, nullable = false)
    public Integer getId_VerticalSections() { return id_VerticalSections; }
    public void setId_VerticalSections(Integer id_VerticalSections) { this.id_VerticalSections = id_VerticalSections; }

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
    @JoinColumn(name = "Stillage")
    public Stillage getStillage() { return stillage; }
    public void setStillage(Stillage stillage) { this.stillage = stillage; }
}
