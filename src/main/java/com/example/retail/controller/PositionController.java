package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PositionDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PositionController
{
    private final PositionService positionService;

    @Autowired // Внедрение зависимости через конструктор
    public PositionController(PositionService positionService)
    {
        this.positionService = positionService;
    }

    /**
     * Создание нового адреса
     * @param positionDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/position", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PositionDTO> create(@RequestBody PositionDTO positionDTO) // Тип ответа явно не указан
    {
        try{ positionService.create(positionDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(positionDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/position", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<PositionDTO>> readAll()
    {
        try{ positionService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<PositionDTO> positionDTOList = positionService.readAll();

        return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/position/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PositionDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ positionService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final PositionDTO positionDTO = positionService.read(id);

        return positionDTO != null // if else
                ? new ResponseEntity<>(positionDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param positionDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/position/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PositionDTO> update(@PathVariable(name = "id") int id, @RequestBody PositionDTO positionDTO)
    {
        try{ positionService.update(positionDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        PositionDTO updatedPositionDTO = positionService.update(positionDTO, id);

        return updatedPositionDTO != null
                ? new ResponseEntity<>(updatedPositionDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/position/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PositionDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ positionService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = positionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
