package com.example.retail.service;

import com.example.retail.model.dto.GroupDTO;
import com.example.retail.model.dto.ImageDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ImageService
{
    /**
     * Загружает новый файл
     * @param file
     * @throws IOException
     * @return
     */
    ImageDTO add(MultipartFile file) throws IOException;

    /**
     * Скачивает файл
     * @param fileName
     * @throws MalformedURLException
     * @return объект адреса
     */
    Resource load(String fileName) throws MalformedURLException;

    /**
     * Удаляет файл с заданным id
     * @param fileName
     * @return true если файл был удален, иначе false
     */
    boolean delete(String fileName);
}
