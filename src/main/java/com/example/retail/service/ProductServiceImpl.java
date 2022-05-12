package com.example.retail.service;

import com.example.retail.mapper.PriceMapper;
import com.example.retail.mapper.ProductMapper;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.entity.Price;
import com.example.retail.model.entity.Product;
import com.example.retail.repository.PriceRepository;
import com.example.retail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    /** Хранилище товаров */
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper)
    {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO)
    {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @Override
    public List<ProductDTO> readAll()
    {
        List<Product> productList = productRepository.findAll();
        return productMapper.listToDTO(productList);
    }

    @Override
    public ProductDTO read(Integer id)
    {
        Product product = productRepository.getById(id);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Integer id)
    {
        Product product = productRepository.getById(id);
        Product producttoEntity = productMapper.toEntity(productDTO);

        if (product != null)
        {
            if (producttoEntity.getId_Product() == null) producttoEntity.setId_Product(product.getId_Product());

            if (producttoEntity.getMengeAufLager() == 0) producttoEntity.setMengeAufLager(product.getMengeAufLager());

            //if (pricetoEntity.getMeasurement() == null) pricetoEntity.setMeasurement(price.getMeasurement());

            return productMapper.toDTO(productRepository.save(producttoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Product product = productRepository.getOne(id);
        if (product != null)
        {
            productRepository.delete(product);
            return true;
        }
        else return false;
    }
}
