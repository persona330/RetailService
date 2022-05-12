package com.example.retail.model.dto;

import com.example.retail.model.entity.Area;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StillageDTO extends BaseDTO
{
    /** Свойство идентификатор стеллажа*/
    private Integer id_Stillage;
    /** Свойство номер*/
    private String number;
    /** Свойство вмещаемый объем*/
    private BigDecimal size;
    /** Свойство зона хранения*/
    private AreaDTO area;

    public Integer getId_Stillage() { return id_Stillage; }
    public void setId_Stillage(Integer id_Stillage) { this.id_Stillage = id_Stillage; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public AreaDTO getAreaDTO() { return area; }
    public void setAreaDTO(AreaDTO area) { this.area = area; }
}
