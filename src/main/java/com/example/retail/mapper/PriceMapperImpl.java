package com.example.retail.mapper;

import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("price1")
public class PriceMapperImpl implements PriceMapper
{
    @Autowired
    private MeasurementMapperImpl measurementMapper;

    @Override
    public Price toEntity(PriceDTO dto)
    {
        if (dto == null) return null;
        Price price = new Price();
        price.setId_Price(dto.getId_Price());
        price.setQuantity(dto.getQuantity());
        price.setMeasurement(measurementMapper.toEntity(dto.getMeasurementDTO()));
        return price;
    }

    @Override
    public PriceDTO toDTO(Price entity)
    {
        if (entity == null) return null;
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setId_Price(entity.getId_Price());
        priceDTO.setQuantity(entity.getQuantity());
        priceDTO.setMeasurementDTO(measurementMapper.toDTO(entity.getMeasurement()));
        return priceDTO;
    }

    public List<PriceDTO> listToDTO(List<Price> list)
    {
        ArrayList<PriceDTO> listDTO = new ArrayList<>();
        for (Price e : list)
        {
            listDTO.add(toDTO(e));
        }
        return listDTO;
    }
}
