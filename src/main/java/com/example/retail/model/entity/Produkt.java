package com.example.retail.model.entity;

import org.springframework.stereotype.Component;

/**
 * Класс товара со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
@Component("produkt")
public class Produkt extends BaseEntity
{
    /** Свойство идентификатор товара*/
    private int id_produkt;
    /**Свойство полное название*/
    private String voll_name;
    /**Свойство количество в наличии*/
    private int menge_auf_lager;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_produkt
     * @param voll_name
     * @param menge_auf_lager
     * @see Produkt#Produkt()
     */
    public Produkt(int id_produkt, String voll_name, int menge_auf_lager)
    {
        this.id_produkt = id_produkt;
        this.voll_name = voll_name;
        this.menge_auf_lager = menge_auf_lager;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Produkt#Produkt(int, String, int)
     */
    public Produkt() {}

    /**
     * Функция задания значения свойства {@link Produkt#id_produkt}
     * @param id_produkt
     */
    public void setIdProdukt(int id_produkt) { this.id_produkt = id_produkt; }
    /**
     * Функция получения значения свойства {@link Produkt#id_produkt}
     * @return значение свойства id_produkt
     */
    public int getIdProdukt() { return id_produkt; }

    public void setVollName(String voll_name) { this.voll_name = voll_name; }
    public String getVollName() { return voll_name; }

    public int getMengeAufLager() { return menge_auf_lager; }
    public void setMengeAufLager(int menge_auf_lager) { this.menge_auf_lager = menge_auf_lager; }
}
