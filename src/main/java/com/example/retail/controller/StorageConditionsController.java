package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StorageConditionsDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.StorageConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StorageConditionsController
{
    private final StorageConditionsService storageConditionsService;

    @Autowired // Внедрение зависимости через конструктор
    public StorageConditionsController(StorageConditionsService storageConditionsService)
    {
        this.storageConditionsService = storageConditionsService;
    }

    /**
     * Создание нового адреса
     * @param storageConditionsDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/storage_conditions", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StorageConditionsDTO> create(@RequestBody StorageConditionsDTO storageConditionsDTO) // Тип ответа явно не указан
    {
        try{
            storageConditionsService.create(storageConditionsDTO);
            return new ResponseEntity<>(storageConditionsDTO, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/storage_conditions", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<StorageConditionsDTO>> readAll()
    {
        try{
            final List<StorageConditionsDTO> storageConditionsDTOList = storageConditionsService.readAll();

            return new ResponseEntity<>(storageConditionsDTOList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/storage_conditions/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StorageConditionsDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final StorageConditionsDTO storageConditionsDTO = storageConditionsService.read(id);

            return storageConditionsDTO != null // if else
                    ? new ResponseEntity<>(storageConditionsDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param storageConditionsDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/storage_conditions/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StorageConditionsDTO> update(@PathVariable(name = "id") int id, @RequestBody StorageConditionsDTO storageConditionsDTO)
    {
        try{
            StorageConditionsDTO updatedStorageConditionsDTO = storageConditionsService.update(storageConditionsDTO, id);

            return updatedStorageConditionsDTO != null
                    ? new ResponseEntity<>(updatedStorageConditionsDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/storage_conditions/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StorageConditionsDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = storageConditionsService.delete(id);

            return deleted
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
