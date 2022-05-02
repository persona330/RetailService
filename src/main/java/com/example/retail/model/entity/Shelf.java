package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Полка со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Shelf
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

    public Integer getId_Shelf() { return id_Shelf; }
    public void setId_Shelf(Integer id_Shelf) { this.id_Shelf = id_Shelf; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    public Stillage getStillage() { return stillage; }
    public void setStillage(Stillage stillage) { this.stillage = stillage; }
}
