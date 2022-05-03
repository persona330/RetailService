package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс товара со свойствами <b>id_Produkt<b/>, <b>mengeAufLager<b/>, <b>menge_auf_lager<b/>
 */

@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRODUCT")
public class Product extends BaseEntity
{
    /** Свойство идентификатор товара*/
    private Integer id_Product;
    /**Свойство количество в наличии*/
    private int mengeAufLager;
    /**Свойство цена за товар*/
    private Price price;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Product
     * @param mengeAufLager
     * @param price
     * @see Product#Product()
     */
    public Product(Integer id_Product, int mengeAufLager, Price price)
    {
        this.id_Product = id_Product;
        this.mengeAufLager = mengeAufLager;
        this.price = price;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Product#Product(Integer, int, Price)
     */
    public Product() {}

    /**
     * Функция получения значения свойства {@link Product#id_Product}
     * @return значение свойства id_Produkt
     */
    @Id
    @GeneratedValue(generator = "SQLProduct", strategy = GenerationType.AUTO)
    @Column(name = "ID_product", unique = true, nullable = false)
    public Integer getId_Product() { return id_Product; }
    /**
     * Функция задания значения свойства {@link Product#id_Product}
     * @param id_Product
     */
    public void setId_Product(Integer id_Product) { this.id_Product = id_Product; }

    @NonNull
    @Column(name = "Menge_auf_lager", length = 10)
    public int getMengeAufLager() { return mengeAufLager; }
    public void setMengeAufLager(int mengeAufLager) { this.mengeAufLager = mengeAufLager; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Price")
    public Price getPrice() { return price; }
    public void setPrice(Price price) { this.price = price; }
}
