package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PriceDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PriceController
{
    private final PriceService priceService;

    @Autowired // Внедрение зависимости через конструктор
    public PriceController(PriceService priceService)
    {
        this.priceService = priceService;
    }

    /**
     * Создание нового адреса
     * @param priceDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/price", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PriceDTO> create(@RequestBody PriceDTO priceDTO) // Тип ответа явно не указан
    {
        try{ priceService.create(priceDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(priceDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/price", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<PriceDTO>> readAll()
    {
        try{ priceService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<PriceDTO> priceDTOList = priceService.readAll();

        return new ResponseEntity<>(priceDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/price/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PriceDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ priceService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final PriceDTO priceDTO = priceService.read(id);

        return priceDTO != null // if else
                ? new ResponseEntity<>(priceDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param priceDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/price/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PriceDTO> update(@PathVariable(name = "id") int id, @RequestBody PriceDTO priceDTO)
    {
        try{ priceService.update(priceDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        PriceDTO updatedPriceDTO = priceService.update(priceDTO, id);

        return updatedPriceDTO != null
                ? new ResponseEntity<>(updatedPriceDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/price/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PriceDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ priceService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = priceService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
