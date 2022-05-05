package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProducerController
{
    private final ProducerService producerService;

    @Autowired // Внедрение зависимости через конструктор
    public ProducerController(ProducerService producerService)
    {
        this.producerService = producerService;
    }

    /**
     * Создание нового адреса
     * @param producerDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/producer", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProducerDTO> create(@RequestBody ProducerDTO producerDTO) // Тип ответа явно не указан
    {
        try{ producerService.create(producerDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(producerDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/producer", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ProducerDTO>> readAll()
    {
        try{ producerService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<ProducerDTO> producerDTOList = producerService.readAll();

        return new ResponseEntity<>(producerDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/producer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProducerDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ producerService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final ProducerDTO producerDTO = producerService.read(id);

        return producerDTO != null // if else
                ? new ResponseEntity<>(producerDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param producerDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/producer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProducerDTO> update(@PathVariable(name = "id") int id, @RequestBody ProducerDTO producerDTO)
    {
        try{ producerService.update(producerDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        ProducerDTO updatedProducerDTO = producerService.update(producerDTO, id);

        return updatedProducerDTO != null
                ? new ResponseEntity<>(updatedProducerDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/producer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProducerDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ producerService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = producerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
