package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.CashVoucherMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CashVoucherDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.CashVoucher;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.CashVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashVoucherServiceImpl implements CashVoucherService
{
    private final CashVoucherRepository cashVoucherRepository;
    private final CashVoucherMapper cashVoucherMapper;

    @Autowired
    public CashVoucherServiceImpl(CashVoucherRepository cashVoucherRepository, CashVoucherMapper cashVoucherMapper)
    {
        this.cashVoucherRepository = cashVoucherRepository;
        this.cashVoucherMapper = cashVoucherMapper;
    }

    @Override
    public CashVoucherDTO create(CashVoucherDTO cashVoucherDTO)
    {
        return cashVoucherMapper.toDTO(cashVoucherRepository.save(cashVoucherMapper.toEntity(cashVoucherDTO)));
    }

    @Override
    public List<CashVoucherDTO> readAll()
    {
        List<CashVoucher> cashVoucherList = cashVoucherRepository.findAll();
        return cashVoucherMapper.listToDTO(cashVoucherList);
    }

    @Override
    public CashVoucherDTO read(Integer id)
    {
        CashVoucher cashVoucher = cashVoucherRepository.getById(id);
        return cashVoucherMapper.toDTO(cashVoucher);
    }

    @Override
    public CashVoucherDTO update(CashVoucherDTO cashVoucherDTO, Integer id)
    {
        CashVoucher cashVoucher = cashVoucherRepository.getById(id);
        CashVoucher cashVouchertoEntity = cashVoucherMapper.toEntity(cashVoucherDTO);

        if (cashVoucher != null)
        {
            if (cashVouchertoEntity.getId_CashVoucher() == null) cashVouchertoEntity.setId_CashVoucher(cashVoucher.getId_CashVoucher());

            if (cashVouchertoEntity.getName() == null) cashVouchertoEntity.setName(cashVoucher.getName());

            if (cashVouchertoEntity.getShift() == 0) cashVouchertoEntity.setShift(cashVoucher.getShift());

            if (cashVouchertoEntity.getLocation() == null) cashVouchertoEntity.setLocation(cashVoucher.getLocation());

            if (cashVouchertoEntity.getRnKkt() == null) cashVouchertoEntity.setRnKkt(cashVoucher.getRnKkt());

            if (cashVouchertoEntity.getZnKkt() == null) cashVouchertoEntity.setZnKkt(cashVoucher.getZnKkt());

            if (cashVouchertoEntity.getFn() == null) cashVouchertoEntity.setFn(cashVoucher.getFn());

            if (cashVouchertoEntity.getFd() == null) cashVouchertoEntity.setFd(cashVoucher.getFd());

            if (cashVouchertoEntity.getVat() == 0) cashVouchertoEntity.setVat(cashVoucher.getVat());

            if (cashVouchertoEntity.getCalculationDateTime() == null) cashVouchertoEntity.setCalculationDateTime(cashVoucher.getCalculationDateTime());

            if (cashVouchertoEntity.getNumberPerShift() == 0) cashVouchertoEntity.setNumberPerShift(cashVoucher.getNumberPerShift());

            if (cashVouchertoEntity.getCalculatedSign() == null) cashVouchertoEntity.setCalculatedSign(cashVoucher.getCalculatedSign());

            if (cashVouchertoEntity.getOrganization() == null) cashVouchertoEntity.setOrganization(cashVoucher.getOrganization());

            if (cashVouchertoEntity.getServiceCost() == null) cashVouchertoEntity.setServiceCost(cashVoucher.getServiceCost());

            return cashVoucherMapper.toDTO(cashVoucherRepository.save(cashVouchertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        CashVoucher cashVoucher = cashVoucherRepository.getOne(id);
        if (cashVoucher != null)
        {
            cashVoucherRepository.delete(cashVoucher);
            return true;
        }
        else return false;
    }
}
