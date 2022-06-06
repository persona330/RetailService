package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO extends BaseDTO
{
    /** Свойство идентификатор изображения*/
    private Integer id_Image;
    /**Свойство заголовок*/
    private String title;
    /**Свойство дата загрузки*/
    private LocalDate uploadDate;
    /**Свойство расширение*/
    private String extension;
    /**Свойство ссылка на скачивание*/
    private String downloadLink;
    /**Свойство размер*/
    private long size;

    public Integer getId_Image() { return id_Image; }
    public void setId_Image(Integer id_Image) { this.id_Image = id_Image; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDate uploadDate) { this.uploadDate = uploadDate; }

    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }

    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
}
