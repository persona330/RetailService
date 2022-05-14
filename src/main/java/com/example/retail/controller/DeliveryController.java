package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DeliveryController
{
    private final DeliveryService deliveryService;

    @Autowired // Внедрение зависимости через конструктор
    public DeliveryController(DeliveryService deliveryService)
    {
        this.deliveryService = deliveryService;
    }

    /**
     * Создание нового адреса
     * @param deliveryDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/delivery", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryDTO> create(@RequestBody DeliveryDTO deliveryDTO) // Тип ответа явно не указан
    {
        try{ deliveryService.create(deliveryDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(deliveryDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/delivery", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<DeliveryDTO>> readAll()
    {
        try{ deliveryService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<DeliveryDTO> deliveryDTOList = deliveryService.readAll();

        return new ResponseEntity<>(deliveryDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/delivery/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ deliveryService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final DeliveryDTO deliveryDTO = deliveryService.read(id);

        return deliveryDTO != null // if else
                ? new ResponseEntity<>(deliveryDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param deliveryDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/delivery/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryDTO> update(@PathVariable(name = "id") int id, @RequestBody DeliveryDTO deliveryDTO)
    {
        try{ deliveryService.update(deliveryDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        DeliveryDTO updatedDeliveryDTO = deliveryService.update(deliveryDTO, id);

        return updatedDeliveryDTO != null
                ? new ResponseEntity<>(updatedDeliveryDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/delivery/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ deliveryService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = deliveryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
