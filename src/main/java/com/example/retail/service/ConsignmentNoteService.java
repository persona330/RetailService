package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ConsignmentNoteDTO;

import java.util.List;

public interface ConsignmentNoteService
{
    /**
     * Создает новый адрес
     * @param consignmentNoteDTO
     * @return
     */
    ConsignmentNoteDTO create(ConsignmentNoteDTO consignmentNoteDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<ConsignmentNoteDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    ConsignmentNoteDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param consignmentNoteDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ConsignmentNoteDTO update(ConsignmentNoteDTO consignmentNoteDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
