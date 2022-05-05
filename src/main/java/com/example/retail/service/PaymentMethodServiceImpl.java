package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.PaymentMethodMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PaymentMethodDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.PaymentMethod;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService
{
    /** Хранилище товаров */
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper paymentMethodMapper;

    @Autowired
    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository, PaymentMethodMapper paymentMethodMapper)
    {
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentMethodMapper = paymentMethodMapper;
    }

    @Override
    public PaymentMethodDTO create(PaymentMethodDTO paymentMethodDTO)
    {
        return paymentMethodMapper.toDTO(paymentMethodRepository.save(paymentMethodMapper.toEntity(paymentMethodDTO)));
    }

    @Override
    public List<PaymentMethodDTO> readAll()
    {
        List<PaymentMethod> paymentMethodList = paymentMethodRepository.findAll();
        return paymentMethodMapper.listToDTO(paymentMethodList);
    }

    @Override
    public PaymentMethodDTO read(Integer id)
    {
        PaymentMethod paymentMethod = paymentMethodRepository.getById(id);
        return paymentMethodMapper.toDTO(paymentMethod);
    }

    @Override
    public PaymentMethodDTO update(PaymentMethodDTO paymentMethodDTO, Integer id)
    {
        PaymentMethod paymentMethod = paymentMethodRepository.getById(id);
        PaymentMethod paymentMethodtoEntity = paymentMethodMapper.toEntity(paymentMethodDTO);

        if (paymentMethod != null)
        {
            if (paymentMethodtoEntity.getId_PaymentMethod() == null) paymentMethodtoEntity.setId_PaymentMethod(paymentMethod.getId_PaymentMethod());

            if (paymentMethodtoEntity.getName() == null) paymentMethodtoEntity.setName(paymentMethod.getName());

            return paymentMethodMapper.toDTO(paymentMethodRepository.save(paymentMethodtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        PaymentMethod paymentMethod = paymentMethodRepository.getOne(id);
        if (paymentMethod != null)
        {
            paymentMethodRepository.delete(paymentMethod);
            return true;
        }
        else return false;
    }
}
