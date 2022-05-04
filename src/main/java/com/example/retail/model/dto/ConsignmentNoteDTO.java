package com.example.retail.model.dto;

import com.example.retail.model.entity.EmployeeStore;
import com.example.retail.model.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConsignmentNoteDTO extends BaseDTO
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

    public Integer getId_ConsignmentNote() { return id_ConsignmentNote; }
    public void setId_ConsignmentNote(Integer id_ConsignmentNote) { this.id_ConsignmentNote = id_ConsignmentNote; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Date getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(Date arrivalDate) { this.arrivalDate = arrivalDate; }

    public boolean isForReturn() { return forReturn; }
    public void setForReturn(boolean forReturn) { this.forReturn = forReturn; }

    public EmployeeStore getEmployeeStore() { return employeeStore; }
    public void setEmployeeStore(EmployeeStore employeeStore) { this.employeeStore = employeeStore; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
