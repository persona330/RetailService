package com.example.retail.model.dto;

import com.example.retail.model.entity.Measurement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends BaseDTO
{
    /** Свойство идентификатор стоимость товара за единицу измерения*/
    private Integer id_Price;
    /**Свойство количество единиц измерения*/
    private int quantity;
    /**Свойство единица измерения*/
    private MeasurementDTO measurement;

    @JsonProperty("id_Price")
    public Integer getId_Price() { return id_Price; }
    public void setId_Price(Integer id_Price) { this.id_Price = id_Price; }

    @JsonProperty("quantity")
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @JsonProperty("measurement")
    public MeasurementDTO getMeasurementDTO() { return measurement; }
    public void setMeasurementDTO(MeasurementDTO measurement) { this.measurement = measurement; }
}
