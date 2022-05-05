package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CalculatedSignDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.CalculatedSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CalculatedSignController
{
    private final CalculatedSignService calculatedSignService;

    @Autowired // Внедрение зависимости через конструктор
    public CalculatedSignController(CalculatedSignService calculatedSignService)
    {
        this.calculatedSignService = calculatedSignService;
    }

    /**
     * Создание нового адреса
     * @param calculatedSignDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/calculated_sign", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CalculatedSignDTO> create(@RequestBody CalculatedSignDTO calculatedSignDTO) // Тип ответа явно не указан
    {
        try{ calculatedSignService.create(calculatedSignDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(calculatedSignDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/calculated_sign", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<CalculatedSignDTO>> readAll()
    {
        try{ calculatedSignService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<CalculatedSignDTO> calculatedSignsDTO = calculatedSignService.readAll();

        return new ResponseEntity<>(calculatedSignsDTO, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/calculated_sign/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CalculatedSignDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ calculatedSignService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final CalculatedSignDTO calculatedSignDTO = calculatedSignService.read(id);

        return calculatedSignDTO != null // if else
                ? new ResponseEntity<>(calculatedSignDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param calculatedSignDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/calculated_sign/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CalculatedSignDTO> update(@PathVariable(name = "id") int id, @RequestBody CalculatedSignDTO calculatedSignDTO)
    {
        try{ calculatedSignService.update(calculatedSignDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        CalculatedSignDTO updatedCalculatedSignDTO = calculatedSignService.update(calculatedSignDTO, id);

        return updatedCalculatedSignDTO != null
                ? new ResponseEntity<>(updatedCalculatedSignDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/calculated_sign/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CalculatedSignDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ calculatedSignService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = calculatedSignService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
