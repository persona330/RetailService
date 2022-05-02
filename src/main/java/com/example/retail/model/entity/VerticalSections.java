package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс ВертикальнаяСекция со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class VerticalSections
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

    public Integer getId_VerticalSections() { return id_VerticalSections; }
    public void setId_VerticalSections(Integer id_VerticalSections) { this.id_VerticalSections = id_VerticalSections; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public Stillage getStillage() { return stillage; }
    public void setStillage(Stillage stillage) { this.stillage = stillage; }
}
