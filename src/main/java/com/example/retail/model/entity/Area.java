package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Зона со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Area
{
    /** Свойство идентификатор средства связи*/
    private Integer id_Area;
    /** Свойство название*/
    private String name;
    /** Свойство вместимость*/
    private BigDecimal capacity;
    /** Свойство условия хранения*/
    private StorageConditions storageConditions;
    /** Свойство склад*/
    private Store store;

    public Area(Integer id_Area, String name, BigDecimal capacity, StorageConditions storageConditions, Store store)
    {
        this.id_Area = id_Area;
        this.name = name;
        this.capacity = capacity;
        this.storageConditions = storageConditions;
        this.store = store;
    }

    public Integer getId_Area() { return id_Area; }
    public void setId_Area(Integer id_Area) { this.id_Area = id_Area; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getCapacity() { return capacity; }
    public void setCapacity(BigDecimal capacity) { this.capacity = capacity; }

    public StorageConditions getStorageConditions() { return storageConditions; }
    public void setStorageConditions(StorageConditions storageConditions) { this.storageConditions = storageConditions; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
