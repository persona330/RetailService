package com.example.retail.controller;

import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.BoxDTO;
import com.example.retail.service.AccountService;
import com.example.retail.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AccountController
{
    private final AccountService accountService;

    @Autowired // Внедрение зависимости через конструктор
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    /**
     * Создание нового адреса
     * @param accountDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/account", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) // Тип ответа явно не указан
    {
        try{ accountService.create(accountDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/account", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<AccountDTO>> readAll()
    {
        try{ accountService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<AccountDTO> accountDTOList = accountService.readAll();

        return new ResponseEntity<>(accountDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/account/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AccountDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ accountService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final AccountDTO accountDTO = accountService.read(id);

        return accountDTO != null // if else
                ? new ResponseEntity<>(accountDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param accountDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/account/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AccountDTO> update(@PathVariable(name = "id") int id, @RequestBody AccountDTO accountDTO)
    {
        try{ accountService.update(accountDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        AccountDTO updatedAccountDTO = accountService.update(accountDTO, id);

        return updatedAccountDTO != null
                ? new ResponseEntity<>(updatedAccountDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/account/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AccountDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ accountService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = accountService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
