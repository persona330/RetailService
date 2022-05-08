package com.example.retail.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO extends BaseDTO
{
    /** Свойство идентификатор номеклатуры на товар*/
    private Integer id_Measurement;
    /**Свойство сокращенное название единицы измерения*/
    private String name;
    /**Свойство полное название единицы измерения*/
    private String fullName;

    @JsonProperty("id_Measurement")
    public Integer getId_Measurement() { return id_Measurement; }
    public void setId_Measurement(Integer id_Measurement) { this.id_Measurement = id_Measurement; }

    @JsonProperty("name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @JsonProperty("fullName")
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
