package com.example.retail.controller;

import com.example.retail.model.dto.WriteOffDTO;
import com.example.retail.service.WriteOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WriteOffController
{
    private final WriteOffService writeOffService;

    @Autowired // Внедрение зависимости через конструктор
    public WriteOffController(WriteOffService writeOffService)
    {
        this.writeOffService = writeOffService;
    }

    /**
     * Создание нового адреса
     * @param writeOffDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/write_off", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> create(@RequestBody WriteOffDTO writeOffDTO) // Тип ответа явно не указан
    {
        try{
            writeOffService.create(writeOffDTO);
            return new ResponseEntity<>(writeOffDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/write_off", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<WriteOffDTO>> readAll()
    {
        try{
            final List<WriteOffDTO> writeOffDTOList = writeOffService.readAll();

            return new ResponseEntity<>(writeOffDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/write_off/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final WriteOffDTO writeOffDTO = writeOffService.read(id);

            return writeOffDTO != null // if else
                    ? new ResponseEntity<>(writeOffDTO, HttpStatus.OK)
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
     * @param writeOffDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/write_off/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> update(@PathVariable(name = "id") int id, @RequestBody WriteOffDTO writeOffDTO)
    {
        try{
            WriteOffDTO updatedWriteOffDTO = writeOffService.update(writeOffDTO, id);

            return updatedWriteOffDTO != null
                    ? new ResponseEntity<>(updatedWriteOffDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/write_off/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = writeOffService.delete(id);

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
