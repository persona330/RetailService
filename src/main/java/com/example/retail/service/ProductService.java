package com.example.retail.service;

import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.dto.ProductDTO;

import java.util.List;

public interface ProductService
{
    /**
     * Создает новую должность
     * @param productDTO
     * @return
     */
    ProductDTO create(ProductDTO productDTO);

    /**Возвращает список всех имеющихся должностей
     * @return список должностей
     */
    List<ProductDTO> readAll();

    /**
     * Возвращает должность по ее id
     * @param id
     * @return объект должность
     */
    ProductDTO read(Integer id);

    /**
     * Обновляет должность с заданным id, в соотвествии с переданной должностью
     * @param productDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ProductDTO update(ProductDTO productDTO, Integer id);

    /**
     * Удаляет должность с заданным id
     * @param id
     * @return true если должность была удалена, иначе false
     */
    boolean delete(Integer id);
}
