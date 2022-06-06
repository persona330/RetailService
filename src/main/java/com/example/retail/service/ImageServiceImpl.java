package com.example.retail.service;

import com.example.retail.config.AppProperties;
import com.example.retail.mapper.ImageMapper;
import com.example.retail.model.dto.ImageDTO;
import com.example.retail.model.entity.Image;
import com.example.retail.repository.ImageRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Service
public class ImageServiceImpl implements ImageService
{
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    private final AppProperties appProperties;

    private String uploadPath = "C:/Users/Lenovo/IdeaProjects/RetailService/src/main/resources/uploads";


    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper, AppProperties appProperties)
    {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
        this.appProperties = appProperties;
    }

    @Override
    public ImageDTO add(MultipartFile file) throws IOException
    {
        //File uploadDir = new File(appProperties.getUploadPath());
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) uploadDir.mkdirs();

        //String fileName = "product_" + LocalDateTime.now().toString() + "_" + file.getOriginalFilename().toLowerCase().replaceAll(" ", "-");
        String fileName = file.getOriginalFilename();
        file.transferTo(new File(uploadDir + "/" + fileName));
        Image image = new Image();
        image.setTitle(fileName);
        image.setUploadDate(LocalDate.now());
        image.setSize(file.getSize());
        image.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
        return imageMapper.toDTO(imageRepository.save(image));
    }

    @Override
    public Resource load(String fileName) throws MalformedURLException
    {
        Image image = imageRepository.findByTitle(fileName);
        Path fileStorageLocation = Paths.get(uploadPath).toAbsolutePath().normalize();
        Path filePath = fileStorageLocation.resolve(image.getTitle()).normalize();
        System.out.println(filePath);
        return new UrlResource(filePath.toUri());
    }

    @Override
    public boolean delete(String fileName)
    {
        Image image = imageRepository.findByTitle(fileName);
        if (image != null)
        {
            Path fileStorageLocation = Paths.get(uploadPath).toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(image.getTitle()).normalize();
            File file = filePath.toFile();
            imageRepository.delete(image);
            file.delete();
            return true;
        }
        else return false;
    }
}
