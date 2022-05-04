package com.example.retail.model.dto;

import com.example.retail.model.entity.BaseEntity;
import com.example.retail.model.entity.StorageConditions;
import com.example.retail.model.entity.Store;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO extends BaseEntity
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
