package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс ЕдиницаИзмерения со свойствами <b>id_Measurement<b/>, <b>name<b/>, <b>fullName<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "MEASUREMENT")
public class Measurement extends BaseEntity
{
    /** Свойство идентификатор номеклатуры на товар*/
    private Integer id_Measurement;
    /**Свойство сокращенное название единицы измерения*/
    private String name;
    /**Свойство полное название единицы измерения*/
    private String fullName;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Measurement
     * @param name
     * @param fullName
     * @see Measurement#Measurement()
     */
    public Measurement(Integer id_Measurement, String name, String fullName)
    {
        this.id_Measurement = id_Measurement;
        this.name = name;
        this.fullName = fullName;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Measurement#Measurement(Integer, String, String)
     */
    public Measurement(){}

    @Id
    @GeneratedValue(generator = "SQLMeasurement", strategy = GenerationType.AUTO)
    @Column(name = "ID_measurement", unique = true, nullable = false)
    public Integer getId_Measurement() { return id_Measurement; }
    public void setId_Measurement(Integer id_Measurement) { this.id_Measurement = id_Measurement; }

    @Basic
    @NonNull
    @Column(name = "Name", length = 10)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Basic
    @NonNull
    @Column(name = "Full_name")
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
