package com.example.retail.service;

import com.example.retail.model.dto.PositionDTO;
import com.example.retail.model.dto.PriceDTO;

import java.util.List;

public interface PriceService
{
    /**
     * Создает новую должность
     * @param priceDTO
     * @return
     */
    PriceDTO create(PriceDTO priceDTO);

    /**Возвращает список всех имеющихся должностей
     * @return список должностей
     */
    List<PriceDTO> readAll();

    /**
     * Возвращает должность по ее id
     * @param id
     * @return объект должность
     */
    PriceDTO read(Integer id);

    /**
     * Обновляет должность с заданным id, в соотвествии с переданной должностью
     * @param priceDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    PriceDTO update(PriceDTO priceDTO, Integer id);

    /**
     * Удаляет должность с заданным id
     * @param id
     * @return true если должность была удалена, иначе false
     */
    boolean delete(Integer id);
}
