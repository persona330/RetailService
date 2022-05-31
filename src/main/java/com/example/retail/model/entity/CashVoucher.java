package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс КассовыйЧек со свойствами <b>id_CashVouchers<b/>, <b>name<b/>, <b>shift<b/>, <b>location<b/>,
 * <b>rnKkt<b/>, <b>znKkt<b/>, <b>fn<b/>, <b>fd<b/>, <b>vat<b/>, <b>calculationDateTime<b/>,
 * <b>numberPerShift<b/>, <b>calculatedSign<b/>, <b>organization<b/>, <b>serviceCost<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "CASH_VOUCHER")
public class CashVoucher extends BaseEntity
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

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_CashVoucher
     * @param name
     * @param shift
     * @param location
     * @param rnKkt
     * @param znKkt
     * @param fn
     * @param fd
     * @param vat
     * @param calculationDateTime
     * @param numberPerShift
     * @param calculatedSign
     * @param organization
     * @param serviceCost
     * @see CashVoucher#CashVoucher()
     */
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
    /**
     * Конструктор - создание нового объекта
     * @see CashVoucher#CashVoucher(Integer, String, int, String, String, String, String, String, int, Date, int, CalculatedSign, Organization, ServiceCost)
     */
    public CashVoucher(){}

    @Id
    @GeneratedValue(generator = "SQLCashVoucher", strategy = GenerationType.AUTO)
    @Column(name = "ID_cash_voucher", unique = true, nullable = false)
    public Integer getId_CashVoucher() { return id_CashVoucher; }
    public void setId_CashVoucher(Integer id_CashVoucher) { this.id_CashVoucher = id_CashVoucher; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @Column(name = "Shift", length = 4)
    public int getShift() { return shift; }
    public void setShift(int shift) { this.shift = shift; }

    @NonNull
    @Column(name = "Location")
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @NonNull
    @Column(name = "RN_KKT", length = 16)
    public String getRnKkt() { return rnKkt; }
    public void setRnKkt(String rnKkt) { this.rnKkt = rnKkt; }

    @NonNull
    @Column(name = "ZN_KKT", length = 16)
    public String getZnKkt() { return znKkt; }
    public void setZnKkt(String znKkt) { this.znKkt = znKkt; }

    @NonNull
    @Column(name = "FN")
    public String getFn() { return fn; }
    public void setFn(String fn) { this.fn = fn; }

    @NonNull
    @Column(name = "FD")
    public String getFd() { return fd; }
    public void setFd(String fd) { this.fd = fd; }

    @NonNull
    @Column(name = "VAT")
    public int getVat() { return vat; }
    public void setVat(int vat) { this.vat = vat; }

    @NonNull
    @Column(name = "Calculation_DateTime")
    public Date getCalculationDateTime() { return calculationDateTime; }
    public void setCalculationDateTime(Date calculationDateTime) { this.calculationDateTime = calculationDateTime; }

    @NonNull
    @Column(name = "Number_per_shift")
    public int getNumberPerShift() { return numberPerShift; }
    public void setNumberPerShift(int numberPerShift) { this.numberPerShift = numberPerShift; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Calculated_sign")
    public CalculatedSign getCalculatedSign() { return calculatedSign; }
    public void setCalculatedSign(CalculatedSign calculatedSign) { this.calculatedSign = calculatedSign; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Service_cost")
    public ServiceCost getServiceCost() { return serviceCost; }
    public void setServiceCost(ServiceCost serviceCost) { this.serviceCost = serviceCost; }
}
