package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.DeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DeliveryMethodController
{
    private final DeliveryMethodService deliveryMethodService;

    @Autowired // Внедрение зависимости через конструктор
    public DeliveryMethodController(DeliveryMethodService deliveryMethodService)
    {
        this.deliveryMethodService = deliveryMethodService;
    }

    /**
     * Создание нового адреса
     * @param deliveryMethodDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/delivery_method", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryMethodDTO> create(@RequestBody DeliveryMethodDTO deliveryMethodDTO) // Тип ответа явно не указан
    {
        try{ deliveryMethodService.create(deliveryMethodDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(deliveryMethodDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/delivery_method", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<DeliveryMethodDTO>> readAll()
    {
        try{ deliveryMethodService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<DeliveryMethodDTO> deliveryMethodDTOList = deliveryMethodService.readAll();

        return new ResponseEntity<>(deliveryMethodDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/delivery_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryMethodDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ deliveryMethodService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final DeliveryMethodDTO deliveryMethodDTO = deliveryMethodService.read(id);

        return deliveryMethodDTO != null // if else
                ? new ResponseEntity<>(deliveryMethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param deliveryMethodDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/delivery_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryMethodDTO> update(@PathVariable(name = "id") int id, @RequestBody DeliveryMethodDTO deliveryMethodDTO)
    {
        try{ deliveryMethodService.update(deliveryMethodDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        DeliveryMethodDTO updatedDeliveryMethodDTO = deliveryMethodService.update(deliveryMethodDTO, id);

        return updatedDeliveryMethodDTO != null
                ? new ResponseEntity<>(updatedDeliveryMethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/delivery_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeliveryMethodDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ deliveryMethodService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = deliveryMethodService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
