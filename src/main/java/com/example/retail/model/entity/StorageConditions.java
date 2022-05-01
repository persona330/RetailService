package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс УсловияХранения со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class StorageConditions
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

    private Measurement measuremenTemperaturet;

    private Measurement measuremenHumidity;

    private Measurement measuremenIllumination;

    public StorageConditions(Integer id_StorageConditions, String name, BigDecimal temperature, BigDecimal humidity, BigDecimal illumination, Measurement measuremenTemperaturet, Measurement measuremenHumidity, Measurement measuremenIllumination)
    {
        this.id_StorageConditions = id_StorageConditions;
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.illumination = illumination;
        this.measuremenTemperaturet = measuremenTemperaturet;
        this.measuremenHumidity = measuremenHumidity;
        this.measuremenIllumination = measuremenIllumination;
    }

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

    public Measurement getMeasuremenTemperaturet() { return measuremenTemperaturet; }
    public void setMeasuremenTemperaturet(Measurement measuremenTemperaturet) { this.measuremenTemperaturet = measuremenTemperaturet; }

    public Measurement getMeasuremenHumidity() { return measuremenHumidity; }
    public void setMeasuremenHumidity(Measurement measuremenHumidity) { this.measuremenHumidity = measuremenHumidity; }

    public Measurement getMeasuremenIllumination() { return measuremenIllumination; }
    public void setMeasuremenIllumination(Measurement measuremenIllumination) { this.measuremenIllumination = measuremenIllumination; }
}
