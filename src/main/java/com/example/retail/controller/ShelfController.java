package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ShelfDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ShelfController
{
    private final ShelfService shelfService;

    @Autowired // Внедрение зависимости через конструктор
    public ShelfController(ShelfService shelfService)
    {
        this.shelfService = shelfService;
    }

    /**
     * Создание нового адреса
     * @param shelfDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/shelf", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ShelfDTO> create(@RequestBody ShelfDTO shelfDTO) // Тип ответа явно не указан
    {
        try{ shelfService.create(shelfDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(shelfDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/shelf", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ShelfDTO>> readAll()
    {
        try{ shelfService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<ShelfDTO> shelfDTOList = shelfService.readAll();

        return new ResponseEntity<>(shelfDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/shelf/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ShelfDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ shelfService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final ShelfDTO shelfDTO = shelfService.read(id);

        return shelfDTO != null // if else
                ? new ResponseEntity<>(shelfDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param shelfDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/shelf/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ShelfDTO> update(@PathVariable(name = "id") int id, @RequestBody ShelfDTO shelfDTO)
    {
        try{ shelfService.update(shelfDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        ShelfDTO updatedShelfDTO = shelfService.update(shelfDTO, id);

        return updatedShelfDTO != null
                ? new ResponseEntity<>(updatedShelfDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/shelf/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ShelfDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ shelfService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = shelfService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
