package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ServiceCostDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.ServiceCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ServiceCostController
{
    private final ServiceCostService serviceCostService;

    @Autowired // Внедрение зависимости через конструктор
    public ServiceCostController(ServiceCostService serviceCostService)
    {
        this.serviceCostService = serviceCostService;
    }

    /**
     * Создание нового адреса
     * @param serviceCostDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/service_cost", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ServiceCostDTO> create(@RequestBody ServiceCostDTO serviceCostDTO) // Тип ответа явно не указан
    {
        try{ serviceCostService.create(serviceCostDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(serviceCostDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/service_cost", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ServiceCostDTO>> readAll()
    {
        try{ serviceCostService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<ServiceCostDTO> serviceCostDTOList = serviceCostService.readAll();

        return new ResponseEntity<>(serviceCostDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/service_cost/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ServiceCostDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ serviceCostService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final ServiceCostDTO serviceCostDTO = serviceCostService.read(id);

        return serviceCostDTO != null // if else
                ? new ResponseEntity<>(serviceCostDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param serviceCostDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/service_cost/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ServiceCostDTO> update(@PathVariable(name = "id") int id, @RequestBody ServiceCostDTO serviceCostDTO)
    {
        try{ serviceCostService.update(serviceCostDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        ServiceCostDTO updatedServiceCostDTO = serviceCostService.update(serviceCostDTO, id);

        return updatedServiceCostDTO != null
                ? new ResponseEntity<>(updatedServiceCostDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/service_cost/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ServiceCostDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ serviceCostService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = serviceCostService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
