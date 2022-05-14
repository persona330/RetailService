package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.GroupDTO;

import java.util.List;

public interface GroupService
{
    /**
     * Создает новый адрес
     * @param groupDTO
     * @return
     */
    GroupDTO create(GroupDTO groupDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<GroupDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    GroupDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param groupDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    GroupDTO update(GroupDTO groupDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
