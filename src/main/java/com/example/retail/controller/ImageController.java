package com.example.retail.controller;

import com.example.retail.model.dto.ImageDTO;
import com.example.retail.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product/image")
@RequiredArgsConstructor
public class ImageController
{
    private final ImageService imageService;

    @Autowired // Внедрение зависимости через конструктор
    public ImageController(ImageService imageService)
    {
        this.imageService = imageService;
    }

    /**
     * Создание нового адреса
     * @param file аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<ImageDTO> upload(@RequestParam MultipartFile file)
    {
        try {
            return new ResponseEntity<>(imageService.add(file), HttpStatus.CREATED);
        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресе
     * @param fileName аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "download/{fileName:.+}")
    public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request)
    {
        try {
            Resource resource = imageService.load(fileName);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Удаление адреса
     * @param fileName
     * @return http статус
     */
    @DeleteMapping(value = "/{fileName:.+}")
    public ResponseEntity<String> delete(@PathVariable String fileName, HttpServletRequest request)
    {
        final boolean deleted = imageService.delete(fileName);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
