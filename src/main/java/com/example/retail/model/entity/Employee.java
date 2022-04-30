package com.example.retail.model.entity;

/**
 * Класс Сщтрудник со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>, <b>house<b/>, <b>street<b/>,
 * <b>region<b/>, <b>city<b/>, <b>nation<b/>
 */
public class Employee extends Person
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация в которой работает*/
    private Organization organization;

    public Employee(String surname, String name, String patronymic, Address address, Communication communication, boolean free, Organization organization)
    {
        super(surname, name, patronymic, address, communication);
        this.free = free;
        this.organization = organization;
    }

    public Employee() {}

    public boolean isFree() { return free; }
    public void setFree(boolean free) { this.free = free; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
