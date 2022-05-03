package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс УсловияХранения со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "STORAGE_CONDITIONS")
public class StorageConditions extends BaseEntity
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

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_StorageConditions
     * @param name
     * @param temperature
     * @param humidity
     * @param illumination
     * @param measuremenTemperature
     * @param measuremenHumidity
     * @param measuremenIllumination
     * @see StorageConditions#StorageConditions()
     */
    public StorageConditions(Integer id_StorageConditions, String name, BigDecimal temperature, BigDecimal humidity, BigDecimal illumination, Measurement measuremenTemperature, Measurement measuremenHumidity, Measurement measuremenIllumination)
    {
        this.id_StorageConditions = id_StorageConditions;
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.illumination = illumination;
        this.measuremenTemperature = measuremenTemperature;
        this.measuremenHumidity = measuremenHumidity;
        this.measuremenIllumination = measuremenIllumination;
    }
    /**
     * Конструктор - создание нового объекта
     * @see StorageConditions#StorageConditions(Integer, String, BigDecimal, BigDecimal, BigDecimal, Measurement, Measurement, Measurement)
     */
    public StorageConditions(){}

    @Id
    @GeneratedValue(generator = "SQLStorageConditions", strategy = GenerationType.AUTO)
    @Column(name = "ID_storage_conditions", unique = true, nullable = false)
    public Integer getId_StorageConditions() { return id_StorageConditions; }
    public void setId_StorageConditions(Integer id_StorageConditions) { this.id_StorageConditions = id_StorageConditions; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Temperature")
    public BigDecimal getTemperature() { return temperature; }
    public void setTemperature(BigDecimal temperature) { this.temperature = temperature; }

    @NonNull
    @Column(name = "Humidity")
    public BigDecimal getHumidity() { return humidity; }
    public void setHumidity(BigDecimal humidity) { this.humidity = humidity; }

    @NonNull
    @Column(name = "Illumination")
    public BigDecimal getIllumination() { return illumination; }
    public void setIllumination(BigDecimal illumination) { this.illumination = illumination; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Measuremen_temperature")
    public Measurement getMeasuremenTemperature() { return measuremenTemperature; }
    public void setMeasuremenTemperature(Measurement measuremenTemperature) { this.measuremenTemperature = measuremenTemperature; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Measuremen_humidity")
    public Measurement getMeasuremenHumidity() { return measuremenHumidity; }
    public void setMeasuremenHumidity(Measurement measuremenHumidity) { this.measuremenHumidity = measuremenHumidity; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Measuremen_illumination")
    public Measurement getMeasuremenIllumination() { return measuremenIllumination; }
    public void setMeasuremenIllumination(Measurement measuremenIllumination) { this.measuremenIllumination = measuremenIllumination; }
}
