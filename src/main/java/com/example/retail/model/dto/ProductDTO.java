package com.example.retail.model.dto;

import com.example.retail.model.entity.Price;
import com.example.retail.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseDTO
{
    /** Свойство идентификатор товара*/
    private Integer id_Product;
    /**Свойство количество в наличии*/
    private int mengeAufLager;
    /**Свойство цена за товар*/
    private PriceDTO price;

    public Integer getId_Product() { return id_Product; }
    public void setId_Product(Integer id_Product) { this.id_Product = id_Product; }

    public int getMengeAufLager() { return mengeAufLager; }
    public void setMengeAufLager(int mengeAufLager) { this.mengeAufLager = mengeAufLager; }

    public PriceDTO getPriceDTO() { return price; }
    public void setPriceDTO(PriceDTO price) { this.price = price; }
}
