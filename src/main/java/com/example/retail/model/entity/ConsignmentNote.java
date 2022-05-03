package com.example.retail.model.entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Накладная со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class ConsignmentNote extends BaseEntity
{
    /** Свойство идентификатор товарной накладной*/
    private Integer id_ConsignmentNote;
    /**Свойство номер накладной*/
    private String number;
    /**Свойство дата прибытия товара*/
    private Date arrivalDate;
    /**Свойство товар на возврат организации поставщику*/
    private boolean forReturn;
    /**Свойство работник склада*/
    private EmployeeStore employeeStore;
    /**Свойство поставщик от организации*/
    private Supplier supplier;

    public ConsignmentNote(Integer id_ConsignmentNote, String number, Date arrivalDate, boolean forReturn, EmployeeStore employeeStore, Supplier supplier)
    {
        this.id_ConsignmentNote = id_ConsignmentNote;
        this.number = number;
        this.arrivalDate = arrivalDate;
        this.forReturn = forReturn;
        this.employeeStore = employeeStore;
        this.supplier = supplier;
    }

    public Integer getId_ConsignmentNote() { return id_ConsignmentNote; }
    public void setId_ConsignmentNote(Integer id_ConsignmentNote) { this.id_ConsignmentNote = id_ConsignmentNote; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @Temporal(TemporalType.DATE)
    public Date getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(Date arrivalDate) { this.arrivalDate = arrivalDate; }

    public boolean isForReturn() { return forReturn; }
    public void setForReturn(boolean forReturn) { this.forReturn = forReturn; }

    public EmployeeStore getEmployeeStore() { return employeeStore; }
    public void setEmployeeStore(EmployeeStore employeeStore) { this.employeeStore = employeeStore; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
