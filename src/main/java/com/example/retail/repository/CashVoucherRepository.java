package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.CashVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashVoucherRepository extends BaseRepository <CashVoucher, Integer>
{
    List<CashVoucher> findAll();
    CashVoucher getById(Integer id);
    void delete(CashVoucher cashVoucher);
    CashVoucher getOne(Integer id);
}
