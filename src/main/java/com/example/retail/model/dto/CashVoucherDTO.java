package com.example.retail.model.dto;

import com.example.retail.model.entity.CalculatedSign;
import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.ServiceCost;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CashVoucherDTO extends BaseDTO
{
    /** Свойство идентификатор средства связи*/
    private Integer id_CashVoucher;
    /** Свойство идентификатор средства связи*/
    private String name;
    /** Свойство смена*/
    private int shift;
    /** Свойство место расчета*/
    private String location;
    /** Свойство рнккт*/
    private String rnKkt;
    /** Свойство знккт*/
    private String znKkt;
    /** Свойство фн*/
    private String fn;
    /** Свойство фд*/
    private String fd;
    /** Свойство фп*/
    private String fp;
    /** Свойство ндс*/
    private int vat;
    /** Свойство дата и время расчета*/
    private Date calculationDateTime;
    /** Свойство номер чека за смену*/
    private int numberPerShift;
    /** Свойство расчетный признак*/
    private CalculatedSignDTO calculatedSign;
    /** Свойство ораганизация*/
    private OrganizationDTO organization;
    /** Свойство стоимость услуги*/
    private ServiceCostDTO serviceCost;

    public Integer getId_CashVoucher() { return id_CashVoucher; }
    public void setId_CashVoucher(Integer id_CashVoucher) { this.id_CashVoucher = id_CashVoucher; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getShift() { return shift; }
    public void setShift(int shift) { this.shift = shift; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getRnKkt() { return rnKkt; }
    public void setRnKkt(String rnKkt) { this.rnKkt = rnKkt; }

    public String getZnKkt() { return znKkt; }
    public void setZnKkt(String znKkt) { this.znKkt = znKkt; }

    public String getFn() { return fn; }
    public void setFn(String fn) { this.fn = fn; }

    public String getFd() { return fd; }
    public void setFd(String fd) { this.fd = fd; }

    public String getFp() { return fp; }
    public void setFp(String fp) { this.fp = fp; }

    public int getVat() { return vat; }
    public void setVat(int vat) { this.vat = vat; }

    public Date getCalculationDateTime() { return calculationDateTime; }
    public void setCalculationDateTime(Date calculationDateTime) { this.calculationDateTime = calculationDateTime; }

    public int getNumberPerShift() { return numberPerShift; }
    public void setNumberPerShift(int numberPerShift) { this.numberPerShift = numberPerShift; }

    public CalculatedSignDTO getCalculatedSignDTO() { return calculatedSign; }
    public void setCalculatedSignDTO(CalculatedSignDTO calculatedSign) { this.calculatedSign = calculatedSign; }

    public OrganizationDTO getOrganizationDTO() { return organization; }
    public void setOrganizationDTO(OrganizationDTO organization) { this.organization = organization; }

    public ServiceCostDTO getServiceCostDTO() { return serviceCost; }
    public void setServiceCostDTO(ServiceCostDTO serviceCost) { this.serviceCost = serviceCost; }
}
