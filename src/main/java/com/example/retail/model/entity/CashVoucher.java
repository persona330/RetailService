package com.example.retail.model.entity;

import java.util.Date;

/**
 * Класс КассовыйЧек со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class CashVoucher
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
    /** Свойство ндс*/
    private int vat;
    /** Свойство дата и время расчета*/
    private Date calculationDateTime;
    /** Свойство номер чека за смену*/
    private int numberPerShift;
    /** Свойство расчетный признак*/
    private CalculatedSign calculatedSign;
    /** Свойство ораганизация*/
    private Organization organization;
    /** Свойство стоимость услуги*/
    private ServiceCost serviceCost;

    public CashVoucher(Integer id_CashVoucher, String name, int shift, String location, String rnKkt, String znKkt, String fn, String fd, int vat, Date calculationDateTime, int numberPerShift, CalculatedSign calculatedSign, Organization organization, ServiceCost serviceCost)
    {
        this.id_CashVoucher = id_CashVoucher;
        this.name = name;
        this.shift = shift;
        this.location = location;
        this.rnKkt = rnKkt;
        this.znKkt = znKkt;
        this.fn = fn;
        this.fd = fd;
        this.vat = vat;
        this.calculationDateTime = calculationDateTime;
        this.numberPerShift = numberPerShift;
        this.calculatedSign = calculatedSign;
        this.organization = organization;
        this.serviceCost = serviceCost;
    }

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

    public int getVat() { return vat; }
    public void setVat(int vat) { this.vat = vat; }

    public Date getCalculationDateTime() { return calculationDateTime; }
    public void setCalculationDateTime(Date calculationDateTime) { this.calculationDateTime = calculationDateTime; }

    public int getNumberPerShift() { return numberPerShift; }
    public void setNumberPerShift(int numberPerShift) { this.numberPerShift = numberPerShift; }

    public CalculatedSign getCalculatedSign() { return calculatedSign; }
    public void setCalculatedSign(CalculatedSign calculatedSign) { this.calculatedSign = calculatedSign; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }

    public ServiceCost getServiceCost() { return serviceCost; }
    public void setServiceCost(ServiceCost serviceCost) { this.serviceCost = serviceCost; }
}
