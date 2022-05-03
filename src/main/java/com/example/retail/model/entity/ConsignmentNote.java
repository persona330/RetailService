package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Накладная со свойствами <b>id_ConsignmentNote<b/>, <b>number<b/>, <b>arrivalDate<b/>, <b>forReturn<b/>,
 * <b>employeeStore<b/>, <b>supplier<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "CONSIGNMENT_NOTE")
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
    public ConsignmentNote(){}

    @Id
    @GeneratedValue(generator = "SQLConsignmentNote", strategy = GenerationType.AUTO)
    @Column(name = "ID_consignment_note", unique = true, nullable = false)
    public Integer getId_ConsignmentNote() { return id_ConsignmentNote; }
    public void setId_ConsignmentNote(Integer id_ConsignmentNote) { this.id_ConsignmentNote = id_ConsignmentNote; }

    @NonNull
    @Column(name = "Number")
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @Temporal(TemporalType.DATE)
    @NonNull
    @Column(name = "Arrival_date")
    public Date getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(Date arrivalDate) { this.arrivalDate = arrivalDate; }

    @NonNull
    @Column(name = "For_return")
    public boolean isForReturn() { return forReturn; }
    public void setForReturn(boolean forReturn) { this.forReturn = forReturn; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Employee_store")
    public EmployeeStore getEmployeeStore() { return employeeStore; }
    public void setEmployeeStore(EmployeeStore employeeStore) { this.employeeStore = employeeStore; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Supplier")
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
