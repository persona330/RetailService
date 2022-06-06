package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class WriteOffDTO extends BaseDTO
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
    private ProductDTO product;
    /** Свойство номенклатура*/
    private NomenclatureDTO nomenclature;

    public Integer getId_WriteOff() { return id_WriteOff; }
    public void setId_WriteOff(Integer id_WriteOff) { this.id_WriteOff = id_WriteOff; }

    public Date getWriteOffDate() { return writeOffDate; }
    public void setWriteOffDate(Date writeOffDate) { this.writeOffDate = writeOffDate; }

    public String getCause() { return cause; }
    public void setCause(String cause) { this.cause = cause; }

    public BigDecimal getSum() { return sum; }
    public void setSum(BigDecimal sum) { this.sum = sum; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ProductDTO getProductDTO() { return product; }
    public void setProductDTO(ProductDTO product) { this.product = product; }

    public NomenclatureDTO getNomenclatureDTO() { return nomenclature; }
    public void setNomenclatureDTO(NomenclatureDTO nomenclature) { this.nomenclature = nomenclature; }
}
