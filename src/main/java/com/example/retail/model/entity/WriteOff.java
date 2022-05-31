package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Списание со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "WRITE_OFF")
public class WriteOff  extends BaseEntity
{
    /** Свойство идентификатор списанного товара*/
    private Integer id_WriteOff;
    /** Свойство дата списания*/
    private Date writeOffDate;
    /** Свойство причина*/
    private String cause;
    /** Свойство сумма*/
    private BigDecimal sum;
    /** Свойство колличество*/
    private int quantity;
    /** Свойство товар*/
    private Product product;
    /** Свойство номенклатура*/
    private Nomenclature nomenclature;

    public WriteOff(Integer id_WriteOff, Date writeOffDate, String cause, BigDecimal sum, int quantity, Product product, Nomenclature nomenclature)
    {
        this.id_WriteOff = id_WriteOff;
        this.writeOffDate = writeOffDate;
        this.cause = cause;
        this.sum = sum;
        this.quantity = quantity;
        this.product = product;
        this.nomenclature = nomenclature;
    }
    public WriteOff() {}

    @Id
    @GeneratedValue(generator = "SQLWriteOff", strategy = GenerationType.AUTO)
    @Column(name = "ID_write_off", unique = true, nullable = false)
    public Integer getId_WriteOff() { return id_WriteOff; }
    public void setId_WriteOff(Integer id_WriteOff) { this.id_WriteOff = id_WriteOff; }

    @NonNull
    @Column(name = "WriteOffDate")
    public Date getWriteOffDate() { return writeOffDate; }
    public void setWriteOffDate(Date writeOffDate) { this.writeOffDate = writeOffDate; }

    @NonNull
    @Column(name = "Cause")
    public String getCause() { return cause; }
    public void setCause(String cause) { this.cause = cause; }

    @NonNull
    @Column(name = "Sum")
    public BigDecimal getSum() { return sum; }
    public void setSum(BigDecimal sum) { this.sum = sum; }

    @NonNull
    @Column(name = "Quantity")
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Product")
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Nomenclature")
    public Nomenclature getNomenclature() { return nomenclature; }
    public void setNomenclature(Nomenclature nomenclature) { this.nomenclature = nomenclature; }
}
