package com.example.retail.model.entity;

/**
 * Класс РаботникСклада со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class EmployeeStore
{
    /** Свойство идентификатор работника склада*/
    private Integer id_EmployeeStore;
    /** Свойство должность*/
    private Position position;
    /** Свойство склад*/
    private Store store;

    public EmployeeStore(Integer id_EmployeeStore, Position position, Store store)
    {
        this.id_EmployeeStore = id_EmployeeStore;
        this.position = position;
        this.store = store;
    }

    public Integer getId_EmployeeStore() { return id_EmployeeStore; }
    public void setId_EmployeeStore(Integer id_EmployeeStore) { this.id_EmployeeStore = id_EmployeeStore; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
