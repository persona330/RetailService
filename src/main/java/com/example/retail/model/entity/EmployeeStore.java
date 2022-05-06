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
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;
    /** Свойство должность*/
    private Position position;
    /** Свойство склад*/
    private Store store;

    public EmployeeStore(String surname, String name, String patronymic, Address address, Communication communication, boolean free, Organization organization, Position position, Store store)
    {
        super(surname, name, patronymic, address, communication);
        this.free = free;
        this.organization = organization;
        this.position = position;
        this.store = store;
    }
    public EmployeeStore(){}

    @NonNull
    @Column(name = "Free")
    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    @Override
    public Organization getOrganization() { return organization; }
    @Override
    public void setOrganization(Organization organization) { this.organization = organization; }

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
