package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Номенклатуры со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "NOMENCLATURE")
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

    public Nomenclature(Integer id_Nomenclature, String name, String brand, BigDecimal cost, Date productionDate, Date expirationDate, BigDecimal weight, BigDecimal size, Producer producer, Group group, Measurement measurement, Box box, StorageConditions storageConditions, Product product)
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
    public Nomenclature(){}

    @Id
    @GeneratedValue(generator = "SQLNomenclature", strategy = GenerationType.AUTO)
    @Column(name = "ID_nomenclature", unique = true, nullable = false)
    public Integer getId_Nomenclature() { return id_Nomenclature; }
    public void setId_Nomenclature(Integer id_Nomenclature) { this.id_Nomenclature = id_Nomenclature; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Brand")
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    @NonNull
    @Column(name = "Cost")
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    @NonNull
    @Column(name = "Production_date")
    public Date getProductionDate() { return productionDate; }
    public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }

    //@Temporal(TemporalType.DATE)
    @NonNull
    @Column(name = "Expiration_date")
    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    @NonNull
    @Column(name = "Weight")
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    @NonNull
    @Column(name = "Size")
    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Producer")
    public Producer getProducer() { return producer; }
    public void setProducer(Producer producer) { this.producer = producer; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Group")
    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Measurement")
    public Measurement getMeasurement() { return measurement; }
    public void setMeasurement(Measurement measurement) { this.measurement = measurement; }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Box")
    public Box getBox() { return box; }
    public void setBox(Box box) { this.box = box; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Storage_conditions")
    public StorageConditions getStorageConditions() { return storageConditions; }
    public void setStorageConditions(StorageConditions storageConditions) { this.storageConditions = storageConditions; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Product")
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
