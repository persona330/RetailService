package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedSignDTO extends BaseDTO
{
    /** Свойство идентификатор расчетного признака*/
    private Integer id_CalculatedSign;
    /** Свойство название*/
    private String name;

    public Integer getId_CalculatedSign() { return id_CalculatedSign; }
    public void setId_CalculatedSign(Integer id_CalculatedSign) { this.id_CalculatedSign = id_CalculatedSign; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
