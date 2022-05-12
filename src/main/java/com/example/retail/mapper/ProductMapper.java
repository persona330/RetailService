package com.example.retail.mapper;


import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.entity.Price;
import com.example.retail.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = PriceMapper.class)
public interface ProductMapper
{
    @Mapping(target = "price", source = "priceDTO")
    Product toEntity(ProductDTO dto);
    @Mapping(target = "priceDTO", source = "price")
    ProductDTO toDTO(Product entity);
    List<ProductDTO> listToDTO(List<Product> entityList);
}
