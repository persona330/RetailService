package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.TransportDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TransportController
{
    private final TransportService transportService;

    @Autowired // Внедрение зависимости через конструктор
    public TransportController(TransportService transportService)
    {
        this.transportService = transportService;
    }
    /**
     * Создание нового адреса
     * @param transportDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/transport", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TransportDTO> create(@RequestBody TransportDTO transportDTO) // Тип ответа явно не указан
    {
        try{ transportService.create(transportDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(transportDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/transport", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<TransportDTO>> readAll()
    {
        try{ transportService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<TransportDTO> transportDTOList = transportService.readAll();

        return new ResponseEntity<>(transportDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/transport/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TransportDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ transportService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final TransportDTO transportDTO = transportService.read(id);

        return transportDTO != null // if else
                ? new ResponseEntity<>(transportDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param transportDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/transport/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TransportDTO> update(@PathVariable(name = "id") int id, @RequestBody TransportDTO transportDTO)
    {
        try{ transportService.update(transportDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        TransportDTO updatedTransportDTO = transportService.update(transportDTO, id);

        return updatedTransportDTO != null
                ? new ResponseEntity<>(updatedTransportDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/transport/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TransportDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ transportService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = transportService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
