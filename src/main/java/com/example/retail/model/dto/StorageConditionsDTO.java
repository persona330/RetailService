package com.example.retail.model.dto;

import com.example.retail.model.entity.Measurement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StorageConditionsDTO extends BaseDTO
{
    /** Свойство идентификатор условий хранения*/
    private Integer id_StorageConditions;
    /** Свойство название*/
    private String name;
    /** Свойство рекомендумая температура*/
    private BigDecimal temperature;
    /** Свойство рекомендуемая влажность*/
    private BigDecimal humidity;
    /** Свойство рекомендуемая освещенность*/
    private BigDecimal illumination;
    /** Свойство единица измерения температуры*/
    private Measurement measuremenTemperature;
    /** Свойство единица измерения влажности*/
    private Measurement measuremenHumidity;
    /** Свойство единиц измерения освещенности*/
    private Measurement measuremenIllumination;

    public Integer getId_StorageConditions() { return id_StorageConditions; }
    public void setId_StorageConditions(Integer id_StorageConditions) { this.id_StorageConditions = id_StorageConditions; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getTemperature() { return temperature; }
    public void setTemperature(BigDecimal temperature) { this.temperature = temperature; }

    public BigDecimal getHumidity() { return humidity; }
    public void setHumidity(BigDecimal humidity) { this.humidity = humidity; }

    public BigDecimal getIllumination() { return illumination; }
    public void setIllumination(BigDecimal illumination) { this.illumination = illumination; }

    public Measurement getMeasuremenTemperature() { return measuremenTemperature; }
    public void setMeasuremenTemperature(Measurement measuremenTemperature) { this.measuremenTemperature = measuremenTemperature; }

    public Measurement getMeasuremenHumidity() { return measuremenHumidity; }
    public void setMeasuremenHumidity(Measurement measuremenHumidity) { this.measuremenHumidity = measuremenHumidity; }

    public Measurement getMeasuremenIllumination() { return measuremenIllumination; }
    public void setMeasuremenIllumination(Measurement measuremenIllumination) { this.measuremenIllumination = measuremenIllumination; }

}
