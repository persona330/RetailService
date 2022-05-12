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
    private ProducerDTO producer;
    /**Свойство группа товара*/
    private GroupDTO group;
    /**Свойство единица измерения*/
    private MeasurementDTO measurement;
    /**Свойство ячейка*/
    private BoxDTO box;
    /**Свойство условия хранения*/
    private StorageConditionsDTO storageConditions;
    /**Свойство продукт*/
    private ProductDTO product;


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

    public ProducerDTO getProducerDTO() { return producer; }
    public void setProducerDTO(ProducerDTO producer) { this.producer = producer; }

    public GroupDTO getGroupDTO() { return group; }
    public void setGroupDTO(GroupDTO group) { this.group = group; }

    public MeasurementDTO getMeasurementDTO() { return measurement; }
    public void setMeasurementDTO(MeasurementDTO measurement) { this.measurement = measurement; }

    public BoxDTO getBoxDTO() { return box; }
    public void setBoxDTO(BoxDTO box) { this.box = box; }

    public StorageConditionsDTO getStorageConditionsDTO() { return storageConditions; }
    public void setStorageConditionsDTO(StorageConditionsDTO storageConditions) { this.storageConditions = storageConditions; }

    public ProductDTO getProductDTO() { return product; }
    public void setProductDTO(ProductDTO product) { this.product = product; }
}
