package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс РаботникСклада со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "EMPLOYEE_STORE")
@PrimaryKeyJoinColumn(name = "Id_employee_store")
public class EmployeeStore extends Employee
{
    /** Свойство должность*/
    private Position position;
    /** Свойство склад*/
    private Store store;

    public EmployeeStore(Integer id, String surname, String name, String patronymic, Address address, Communication communication, boolean free, Organization organization, Position position, Store store)
    {
        super(id, surname, name, patronymic, address, communication, free, organization);
        this.position = position;
        this.store = store;
    }
    public EmployeeStore(){}

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Position")
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Store")
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
