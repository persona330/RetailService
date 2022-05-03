package com.example.retail.model.entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Номенклатуры со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class Nomenclature extends BaseEntity
{
    /** Свойство идентификатор номеклатуры на товар*/
    private Integer id_Nomenclature;
    /**Свойство наименование товара*/
    private String name;
    /**Свойство бренд*/
    private String brand;
    /** Свойство цена товара*/
    private BigDecimal cost;
    @Temporal(TemporalType.DATE)
    /**Свойство дата производства товара*/
    private Date productionDate;
    /**Свойство срок годности товара*/
    private int expirationDate;
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

    public Nomenclature(Integer id_Nomenclature, String name, String brand, BigDecimal cost, Date productionDate, int expirationDate, BigDecimal weight, BigDecimal size, Producer producer, Group group, Measurement measurement, Box box, StorageConditions storageConditions, Product product)
    {
        this.id_Nomenclature = id_Nomenclature;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.weight = weight;
        this.size = size;
        this.producer = producer;
        this.group = group;
        this.measurement = measurement;
        this.box = box;
        this.storageConditions = storageConditions;
        this.product = product;
    }

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

    public int getExpirationDate() { return expirationDate; }
    public void setExpirationDate(int expirationDate) { this.expirationDate = expirationDate; }

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
