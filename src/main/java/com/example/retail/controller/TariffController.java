package com.example.retail.controller;

import com.example.retail.model.dto.TariffDTO;
import com.example.retail.model.dto.TransportDTO;
import com.example.retail.service.TariffService;
import com.example.retail.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TariffController
{
    private final TariffService tariffService;

    @Autowired // Внедрение зависимости через конструктор
    public TariffController(TariffService tariffService)
    {
        this.tariffService = tariffService;
    }
    /**
     * Создание нового адреса
     * @param tariffDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/tariff", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TariffDTO> create(@RequestBody TariffDTO tariffDTO) // Тип ответа явно не указан
    {
        try{ tariffService.create(tariffDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(tariffDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/tariff", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<TariffDTO>> readAll()
    {
        try{ tariffService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<TariffDTO> tariffDTOList = tariffService.readAll();

        return new ResponseEntity<>(tariffDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/tariff/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TariffDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ tariffService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final TariffDTO tariffDTO = tariffService.read(id);

        return tariffDTO != null // if else
                ? new ResponseEntity<>(tariffDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param tariffDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/tariff/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TariffDTO> update(@PathVariable(name = "id") int id, @RequestBody TariffDTO tariffDTO)
    {
        try{ tariffService.update(tariffDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        TariffDTO updatedTariffDTO = tariffService.update(tariffDTO, id);

        return updatedTariffDTO != null
                ? new ResponseEntity<>(updatedTariffDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/tariff/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<TariffDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ tariffService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = tariffService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
