package com.example.retail.model.dto;

import com.example.retail.model.entity.ConsignmentNote;
import com.example.retail.model.entity.Nomenclature;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImportDTO extends BaseDTO
{
    /** Свойство идентификатор привоза товара на склад*/
    private Integer id_Import;
    /**Свойство количество привезенного товара*/
    private int quantity;
    /** Свойство цена товаров*/
    private BigDecimal cost;
    /**Свойство НДС*/
    private int vat;
    /**Свойство накладная*/
    private ConsignmentNote consignmentNote;
    /**Свойство номенклатура*/
    private Nomenclature nomenclature;

    public Integer getId_Import() { return id_Import; }
    public void setId_Import(Integer id_Import) { this.id_Import = id_Import; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public int getVat() { return vat; }
    public void setVat(int vat) { this.vat = vat; }

    public ConsignmentNote getConsignmentNote() { return consignmentNote; }
    public void setConsignmentNote(ConsignmentNote consignmentNote) { this.consignmentNote = consignmentNote; }

    public Nomenclature getNomenclature() { return nomenclature; }
    public void setNomenclature(Nomenclature nomenclature) { this.nomenclature = nomenclature; }
}
