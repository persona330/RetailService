package com.example.retail.model.dto;

import com.example.retail.model.entity.Measurement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends BaseDTO
{
    /** Свойство идентификатор стоимость товара за единицу измерения*/
    private Integer id_PriceFor;
    /**Свойство количество единиц измерения*/
    private int quantity;
    /**Свойство единица измерения*/
    private Measurement measurement;

    public Integer getId_PriceFor() { return id_PriceFor; }
    public void setId_PriceFor(Integer id_PriceFor) { this.id_PriceFor = id_PriceFor; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Measurement getMeasurement() { return measurement; }
    public void setMeasurement(Measurement measurement) { this.measurement = measurement; }
}
