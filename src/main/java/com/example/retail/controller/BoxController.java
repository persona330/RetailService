package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.BoxDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BoxController
{
    private final BoxService boxService;

    @Autowired // Внедрение зависимости через конструктор
    public BoxController(BoxService boxService)
    {
        this.boxService = boxService;
    }

    /**
     * Создание нового адреса
     * @param boxDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/box", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<BoxDTO> create(@RequestBody BoxDTO boxDTO) // Тип ответа явно не указан
    {
        try{ boxService.create(boxDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(boxDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/box", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<BoxDTO>> readAll()
    {
        try{ boxService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<BoxDTO> boxDTOList = boxService.readAll();

        return new ResponseEntity<>(boxDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/box/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<BoxDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ boxService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final BoxDTO boxDTO = boxService.read(id);

        return boxDTO != null // if else
                ? new ResponseEntity<>(boxDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param boxDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/box/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<BoxDTO> update(@PathVariable(name = "id") int id, @RequestBody BoxDTO boxDTO)
    {
        try{ boxService.update(boxDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        BoxDTO updatedBoxDTO = boxService.update(boxDTO, id);

        return updatedBoxDTO != null
                ? new ResponseEntity<>(updatedBoxDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/box/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<BoxDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ boxService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = boxService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
