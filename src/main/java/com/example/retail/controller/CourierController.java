package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CourierDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourierController
{
    private final CourierService courierService;

    @Autowired // Внедрение зависимости через конструктор
    public CourierController(CourierService courierService)
    {
        this.courierService = courierService;
    }

    /**
     * Создание нового адреса
     * @param courierDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/courier", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CourierDTO> create(@RequestBody CourierDTO courierDTO) // Тип ответа явно не указан
    {
        try{ courierService.create(courierDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(courierDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/courier", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<CourierDTO>> readAll()
    {
        try{ courierService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<CourierDTO> courierDTOList = courierService.readAll();

        return new ResponseEntity<>(courierDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/courier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CourierDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ courierService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final CourierDTO courierDTO = courierService.read(id);

        return courierDTO != null // if else
                ? new ResponseEntity<>(courierDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param courierDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/courier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CourierDTO> update(@PathVariable(name = "id") int id, @RequestBody CourierDTO courierDTO)
    {
        try{ courierService.update(courierDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        CourierDTO updatedCourierDTO = courierService.update(courierDTO, id);

        return updatedCourierDTO != null
                ? new ResponseEntity<>(updatedCourierDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/courier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CourierDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ courierService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = courierService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
