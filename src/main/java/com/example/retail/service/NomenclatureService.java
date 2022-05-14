package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.NomenclatureDTO;

import java.util.List;

public interface NomenclatureService
{
    /**
     * Создает новый адрес
     * @param nomenclatureDTO
     * @return
     */
    NomenclatureDTO create(NomenclatureDTO nomenclatureDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<NomenclatureDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    NomenclatureDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param nomenclatureDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    NomenclatureDTO update(NomenclatureDTO nomenclatureDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
