package com.example.retail.model.dto;

import com.example.retail.model.entity.Group;
import com.example.retail.model.entity.Stillage;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ShelfDTO extends BaseDTO
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
