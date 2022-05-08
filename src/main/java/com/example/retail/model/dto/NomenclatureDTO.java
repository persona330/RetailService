package com.example.retail.model.dto;

import com.example.retail.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class NomenclatureDTO extends BaseDTO
{
    /** Свойство идентификатор номеклатуры на товар*/
    private Integer id_Nomenclature;
    /**Свойство наименование товара*/
    private String name;
    /**Свойство бренд*/
    private String brand;
    /** Свойство цена товара*/
    private BigDecimal cost;
    /**Свойство дата производства товара*/
    private Date productionDate;
    /**Свойство срок годности товара*/
    private Date expirationDate;
    /**Свойство вес товара*/
    private BigDecimal weight;
    /**Свойство объем товара*/
    private BigDecimal size;
    /**Свойство производитель*/
    private Producer producer;
    /**Свойство группа товара*/
    private Group group;
    /**Свойство единица измерения*/
    private Measurement measurement;
    /**Свойство ячейка*/
    private Box box;
    /**Свойство условия хранения*/
    private StorageConditions storageConditions;
    /**Свойство продукт*/
    private Product product;


    public Integer getId_Nomenclature() { return id_Nomenclature; }
    public void setId_Nomenclature(Integer id_Nomenclature) { this.id_Nomenclature = id_Nomenclature; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public Date getProductionDate() { return productionDate; }
    public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public Producer getProducer() { return producer; }
    public void setProducer(Producer producer) { this.producer = producer; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    public Measurement getMeasurement() { return measurement; }
    public void setMeasurement(Measurement measurement) { this.measurement = measurement; }

    public Box getBox() { return box; }
    public void setBox(Box box) { this.box = box; }

    public StorageConditions getStorageConditions() { return storageConditions; }
    public void setStorageConditions(StorageConditions storageConditions) { this.storageConditions = storageConditions; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
