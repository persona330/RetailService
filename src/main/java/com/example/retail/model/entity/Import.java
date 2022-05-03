package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Привоз со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class Import extends BaseEntity
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

    public Import(Integer id_Import, int quantity, BigDecimal cost, int vat, ConsignmentNote consignmentNote, Nomenclature nomenclature)
    {
        this.id_Import = id_Import;
        this.quantity = quantity;
        this.cost = cost;
        this.vat = vat;
        this.consignmentNote = consignmentNote;
        this.nomenclature = nomenclature;
    }

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
