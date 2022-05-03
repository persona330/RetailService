package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс РасчетныйПризнак со свойствами <b>id_CalculatedSign<b/>, <b>name<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "CALCULATED_SIGN")
public class CalculatedSign extends BaseEntity
{
    /** Свойство идентификатор расчетного признака*/
    private Integer id_CalculatedSign;
    /** Свойство название*/
    private String name;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_CalculatedSign
     * @param name
     * @see CalculatedSign#CalculatedSign()
     */
    public CalculatedSign(Integer id_CalculatedSign, String name)
    {
        this.id_CalculatedSign = id_CalculatedSign;
        this.name = name;
    }
    /**
     * Конструктор - создание нового объекта
     * @see CalculatedSign#CalculatedSign(Integer, String)
     */
    public CalculatedSign(){}

    @Id
    @GeneratedValue(generator = "SQLCalculatedSign", strategy = GenerationType.AUTO)
    @Column(name = "ID_calculated_sign", unique = true, nullable = false)
    public Integer getId_CalculatedSign() { return id_CalculatedSign; }
    public void setId_CalculatedSign(Integer id_CalculatedSign) { this.id_CalculatedSign = id_CalculatedSign; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
