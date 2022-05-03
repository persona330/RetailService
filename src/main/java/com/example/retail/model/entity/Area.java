package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Зона со свойствами <b>id_Area<b/>, <b>name<b/>, <b>capacity<b/>, <b>storageConditions<b/>, <b>store<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "AREA")
public class Area extends BaseEntity
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

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Area
     * @param name
     * @param capacity
     * @param storageConditions
     * @param store
     * @see Area#Area()
     */
    public Area(Integer id_Area, String name, BigDecimal capacity, StorageConditions storageConditions, Store store)
    {
        this.id_Area = id_Area;
        this.name = name;
        this.capacity = capacity;
        this.storageConditions = storageConditions;
        this.store = store;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Area#Area(Integer, String, BigDecimal, StorageConditions, Store)
     */
    public Area(){}

    @Id
    @GeneratedValue(generator = "SQLArea", strategy = GenerationType.AUTO)
    @Column(name = "ID_area", unique = true, nullable = false)
    public Integer getId_Area() { return id_Area; }
    public void setId_Area(Integer id_Area) { this.id_Area = id_Area; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Capacity")
    public BigDecimal getCapacity() { return capacity; }
    public void setCapacity(BigDecimal capacity) { this.capacity = capacity; }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Storage_сonditions")
    public StorageConditions getStorageConditions() { return storageConditions; }
    public void setStorageConditions(StorageConditions storageConditions) { this.storageConditions = storageConditions; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Store")
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
