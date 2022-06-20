package com.example.retail.controller;

import com.example.retail.model.dto.PriceDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.service.PriceService;
import com.example.retail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController
{
    private final ProductService productService;

    @Autowired // Внедрение зависимости через конструктор
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    /**
     * Создание нового адреса
     * @param productDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/product", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) // Тип ответа явно не указан
    {
        try{
            productService.create(productDTO);
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/product", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ProductDTO>> readAll()
    {
        try{
            final List<ProductDTO> productDTOList = productService.readAll();

            return new ResponseEntity<>(productDTOList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/product/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProductDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final ProductDTO productDTO = productService.read(id);

            return productDTO != null // if else
                    ? new ResponseEntity<>(productDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param productDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/product/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProductDTO> update(@PathVariable(name = "id") int id, @RequestBody ProductDTO productDTO)
    {
        try{
            ProductDTO updatedProductDTO = productService.update(productDTO, id);

            return updatedProductDTO != null
                    ? new ResponseEntity<>(updatedProductDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/product/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ProductDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = productService.delete(id);

            return deleted
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
