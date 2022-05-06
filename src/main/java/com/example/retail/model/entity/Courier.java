package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Курьер со свойствами <b>free<b/>, <b>name<b/>, <b>organization<b/>, <b>transport<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "COURIER")
@PrimaryKeyJoinColumn(name = "Id_courier")
public class Courier extends Employee
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;
    /** Свойство транспорт*/
    private Transport transport;

    public Courier(String surname, String name, String patronymic, Address address, Communication communication, Transport transport)
    {
        super(surname, name, patronymic, address, communication);
        this.free = free;
        this.organization = organization;
        this.transport = transport;
    }

    public Courier() {
    }

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
    @JoinColumn(name = "Transport")
    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }
}
