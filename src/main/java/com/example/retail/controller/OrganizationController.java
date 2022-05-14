package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrganizationDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrganizationController
{
    private final OrganizationService organizationService;

    @Autowired // Внедрение зависимости через конструктор
    public OrganizationController(OrganizationService organizationService)
    {
        this.organizationService = organizationService;
    }

    /**
     * Создание нового адреса
     * @param organizationDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/organization", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrganizationDTO> create(@RequestBody OrganizationDTO organizationDTO) // Тип ответа явно не указан
    {
        try{ organizationService.create(organizationDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(organizationDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/organization", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<OrganizationDTO>> readAll()
    {
        try{ organizationService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<OrganizationDTO> organizationDTOList = organizationService.readAll();

        return new ResponseEntity<>(organizationDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/organization/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrganizationDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ organizationService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final OrganizationDTO organizationDTO = organizationService.read(id);

        return organizationDTO != null // if else
                ? new ResponseEntity<>(organizationDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param organizationDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/organization/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrganizationDTO> update(@PathVariable(name = "id") int id, @RequestBody OrganizationDTO organizationDTO)
    {
        try{ organizationService.update(organizationDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        OrganizationDTO updatedOrganizationDTO = organizationService.update(organizationDTO, id);

        return updatedOrganizationDTO != null
                ? new ResponseEntity<>(updatedOrganizationDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/organization/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrganizationDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ organizationService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = organizationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
