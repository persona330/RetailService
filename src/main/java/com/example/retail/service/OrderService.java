package com.example.retail.service;

import com.example.retail.model.dto.OrderDTO;
import com.example.retail.model.dto.PositionDTO;

import java.util.List;

public interface OrderService
{
    /**
     * Создает новую должность
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**Возвращает список всех имеющихся должностей
     * @return список должностей
     */
    List<OrderDTO> readAll();

    /**
     * Возвращает должность по ее id
     * @param id
     * @return объект должность
     */
    OrderDTO read(Integer id);

    /**
     * Обновляет должность с заданным id, в соотвествии с переданной должностью
     * @param orderDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    OrderDTO update(OrderDTO orderDTO, Integer id);

    /**
     * Удаляет должность с заданным id
     * @param id
     * @return true если должность была удалена, иначе false
     */
    boolean delete(Integer id);
}
