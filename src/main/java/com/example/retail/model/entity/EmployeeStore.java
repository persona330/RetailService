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

    public EmployeeStore(boolean free, Organization organization, Position position, Store store)
    {
        this.free = free;
        this.organization = organization;
        this.position = position;
        this.store = store;
    }
    public EmployeeStore(){}

    @Id
    @GeneratedValue(generator = "SQLEmployeeStore")
    @Column(name = "ID_employee_store", unique = true, nullable = false)
    @Override
    public Integer get_Id() { return super.get_Id(); }
    @Override
    public void set_Id(Integer id) { super.set_Id(id); }

    @NonNull
    @Column(name = "Surname")
    @Override
    public String getSurname() { return super.getSurname(); }
    @Override
    public void setSurname(String surname) { super.setSurname(surname); }

    @NonNull
    @Column(name = "Name")
    @Override
    public String getName() { return super.getName(); }
    @Override
    public void setName(String name) { super.setName(name); }

    @Value("Нет")
    @Column(name = "Patronymic")
    @Override
    public String getPatronymic() { return super.getPatronymic(); }
    @Override
    public void setPatronymic(String patronymic) { super.setPatronymic(patronymic); }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Address")
    @Override
    public Address getAddress() { return super.getAddress(); }
    @Override
    public void setAddress(Address address) { super.setAddress(address); }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Communication")
    @Override
    public Communication getCommunication() { return super.getCommunication(); }
    @Override
    public void setCommunication(Communication communication) { super.setCommunication(communication); }

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
