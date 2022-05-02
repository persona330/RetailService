package com.example.retail.model.entity;

/**
 * Класс РасчетныйПризнак со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class CalculatedSign
{
    /** Свойство идентификатор расчетного признака*/
    private Integer id_CalculatedSign;
    /** Свойство название*/
    private String name;

    public CalculatedSign(Integer id_CalculatedSign, String name)
    {
        this.id_CalculatedSign = id_CalculatedSign;
        this.name = name;
    }

    public Integer getId_CalculatedSign() { return id_CalculatedSign; }
    public void setId_CalculatedSign(Integer id_CalculatedSign) { this.id_CalculatedSign = id_CalculatedSign; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
