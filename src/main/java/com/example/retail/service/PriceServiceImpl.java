package com.example.retail.service;

import com.example.retail.mapper.PriceMapperImpl;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Price;
import com.example.retail.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService
{
    /** Хранилище товаров */
    private final PriceRepository priceRepository;
    //private final PriceMapper priceMapper;
    private final PriceMapperImpl priceMapper;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, PriceMapperImpl priceMapper)
    {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public PriceDTO create(PriceDTO priceDTO)
    {
        return priceMapper.toDTO(priceRepository.save(priceMapper.toEntity(priceDTO)));
    }

    @Override
    public List<PriceDTO> readAll()
    {
        List<Price> priceList = priceRepository.findAll();
        return priceMapper.listToDTO(priceList);
    }

    @Override
    public PriceDTO read(Integer id)
    {
        Price price = priceRepository.getById(id);
        return priceMapper.toDTO(price);
    }

    @Override
    public PriceDTO update(PriceDTO priceDTO, Integer id)
    {
        Price price = priceRepository.getById(id);
        Price pricetoEntity = priceMapper.toEntity(priceDTO);

        if (price != null)
        {
            if (pricetoEntity.getId_Price() == null) pricetoEntity.setId_Price(price.getId_Price());

            if (pricetoEntity.getQuantity() == 0) pricetoEntity.setQuantity(price.getQuantity());

            if (pricetoEntity.getMeasurement() == null) pricetoEntity.setMeasurement(price.getMeasurement());

            return priceMapper.toDTO(priceRepository.save(pricetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Price price = priceRepository.getOne(id);
        if (price != null)
        {
            priceRepository.delete(price);
            return true;
        }
        else return false;
    }
}
