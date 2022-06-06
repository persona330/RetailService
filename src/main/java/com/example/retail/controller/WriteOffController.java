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
        try{ writeOffService.create(writeOffDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(writeOffDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/write_off", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<WriteOffDTO>> readAll()
    {
        try{ writeOffService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<WriteOffDTO> writeOffDTOList = writeOffService.readAll();

        return new ResponseEntity<>(writeOffDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/write_off/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ writeOffService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final WriteOffDTO writeOffDTO = writeOffService.read(id);

        return writeOffDTO != null // if else
                ? new ResponseEntity<>(writeOffDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        try{ writeOffService.update(writeOffDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        WriteOffDTO updatedWriteOffDTO = writeOffService.update(writeOffDTO, id);

        return updatedWriteOffDTO != null
                ? new ResponseEntity<>(updatedWriteOffDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/write_off/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<WriteOffDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ writeOffService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = writeOffService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
