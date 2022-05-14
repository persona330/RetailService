package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;

import java.util.List;

public interface EmployeeStoreService
{
    /**
     * Создает новый адрес
     * @param employeeStoreDTO
     * @return
     */
    EmployeeStoreDTO create(EmployeeStoreDTO employeeStoreDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<EmployeeStoreDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    EmployeeStoreDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param employeeStoreDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    EmployeeStoreDTO update(EmployeeStoreDTO employeeStoreDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
