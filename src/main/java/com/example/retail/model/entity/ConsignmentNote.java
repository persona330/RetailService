package com.example.retail.model.entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Накладная со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class ConsignmentNote extends BaseEntity
{
    /** Свойство идентификатор товарной накладной*/
    private int id_ConsignmentNote;
    /**Свойство номер накладной*/
    private char number;
    @Temporal(TemporalType.DATE)
    /**Свойство дата прибытия товара*/
    private Date arrivalDate;
    /**Свойство товар на возврат организации поставщику*/
    private boolean forReturn;
}
