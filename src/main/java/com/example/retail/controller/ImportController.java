package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ImportDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ImportController
{
    private final ImportService importService;

    @Autowired // Внедрение зависимости через конструктор
    public ImportController(ImportService importService)
    {
        this.importService = importService;
    }

    /**
     * Создание нового адреса
     * @param importDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/import", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ImportDTO> create(@RequestBody ImportDTO importDTO) // Тип ответа явно не указан
    {
        try
        {
            importService.create(importDTO);
            return new ResponseEntity<>(importDTO, HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/import", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ImportDTO>> readAll()
    {
        try
        {
            final List<ImportDTO> importDTOList = importService.readAll();
            return new ResponseEntity<>(importDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/import/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ImportDTO> read(@PathVariable(name = "id") Integer id)
    {
        try
        {
            final ImportDTO importDTO = importService.read(id);
            return importDTO != null // if else
                    ? new ResponseEntity<>(importDTO, HttpStatus.OK)
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
     * @param importDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/import/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ImportDTO> update(@PathVariable(name = "id") int id, @RequestBody ImportDTO importDTO)
    {
        try
        {
            ImportDTO updatedImportDTO = importService.update(importDTO, id);
            return updatedImportDTO != null
                    ? new ResponseEntity<>(updatedImportDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/import/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ImportDTO> delete(@PathVariable(name = "id") int id)
    {
        try
        {
            final boolean deleted = importService.delete(id);
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
