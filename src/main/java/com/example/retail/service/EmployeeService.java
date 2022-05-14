package com.example.retail.service;

import com.example.retail.model.dto.EmployeeDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;

import java.util.List;

public interface EmployeeService
{
    /**
     * Создает новый адрес
     * @param employeeDTO
     * @return
     */
    EmployeeDTO create(EmployeeDTO employeeDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<EmployeeDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    EmployeeDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param employeeDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    EmployeeDTO update(EmployeeDTO employeeDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
