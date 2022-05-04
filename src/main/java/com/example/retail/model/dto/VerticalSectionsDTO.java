package com.example.retail.model.dto;

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
public class VerticalSectionsDTO extends BaseDTO
{
    /** Свойство идентификатор вертикальной секции*/
    private Integer id_VerticalSections;
    /** Свойство номер*/
    private String number;
    /** Свойство вместимость*/
    private BigDecimal size;
    /** Свойство стеллаж*/
    private Stillage stillage;

    public Integer getId_VerticalSections() { return id_VerticalSections; }
    public void setId_VerticalSections(Integer id_VerticalSections) { this.id_VerticalSections = id_VerticalSections; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public Stillage getStillage() { return stillage; }
    public void setStillage(Stillage stillage) { this.stillage = stillage; }
}
