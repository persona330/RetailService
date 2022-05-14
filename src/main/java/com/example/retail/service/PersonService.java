package com.example.retail.service;

import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.model.dto.PaymentMethodDTO;
import com.example.retail.model.dto.PersonDTO;

import java.util.List;

public interface PersonService
{
    /**
     * Создает новый адрес
     * @param personDTO
     * @return
     */
    PersonDTO create(PersonDTO personDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<PersonDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    PersonDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param personDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    PersonDTO update(PersonDTO personDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
