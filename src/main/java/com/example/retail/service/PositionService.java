package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PositionDTO;

import java.util.List;

public interface PositionService
{
    /**
     * Создает новую должность
     * @param positionDTO
     * @return
     */
    PositionDTO create(PositionDTO positionDTO);

    /**Возвращает список всех имеющихся должностей
     * @return список должностей
     */
    List<PositionDTO> readAll();

    /**
     * Возвращает должность по ее id
     * @param id
     * @return объект должность
     */
    PositionDTO read(Integer id);

    /**
     * Обновляет должность с заданным id, в соотвествии с переданной должностью
     * @param positionDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    PositionDTO update(PositionDTO positionDTO, Integer id);

    /**
     * Удаляет должность с заданным id
     * @param id
     * @return true если должность была удалена, иначе false
     */
    boolean delete(Integer id);
}
