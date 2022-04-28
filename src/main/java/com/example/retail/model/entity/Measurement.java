package com.example.retail.model.entity;

/**
 * Класс ЕдиницаИзмерения со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Measurement
{
    /** Свойство идентификатор номеклатуры на товар*/
    private Integer id_Measurement;
    /**Свойство сокращенное название единицы измерения*/
    private String name;
    /**Свойство полное название единицы измерения*/
    private String fullName;

    public Measurement(Integer id_Measurement, String name, String fullName) {
        this.id_Measurement = id_Measurement;
        this.name = name;
        this.fullName = fullName;
    }
    public Measurement(){}

    public Integer getId_Measurement() { return id_Measurement; }
    public void setId_Measurement(Integer id_Measurement) { this.id_Measurement = id_Measurement; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
