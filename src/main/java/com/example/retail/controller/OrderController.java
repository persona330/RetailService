package com.example.retail.controller;

import com.example.retail.model.dto.OrderDTO;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.service.OrderService;
import com.example.retail.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrderController
{
    private final OrderService orderService;

    @Autowired // Внедрение зависимости через конструктор
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    /**
     * Создание нового адреса
     * @param orderDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/order", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) // Тип ответа явно не указан
    {
        try{ orderService.create(orderDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/order", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<OrderDTO>> readAll()
    {
        try{ orderService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<OrderDTO> orderDTOList = orderService.readAll();

        return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/order/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ orderService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final OrderDTO orderDTO = orderService.read(id);

        return orderDTO != null // if else
                ? new ResponseEntity<>(orderDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param orderDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/order/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderDTO> update(@PathVariable(name = "id") int id, @RequestBody OrderDTO orderDTO)
    {
        try{ orderService.update(orderDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        OrderDTO updatedOrderDTO = orderService.update(orderDTO, id);

        return updatedOrderDTO != null
                ? new ResponseEntity<>(updatedOrderDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/order/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ orderService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = orderService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
