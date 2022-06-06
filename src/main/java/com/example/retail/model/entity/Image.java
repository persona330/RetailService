package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Класс Изображение со свойствами <b>id_Produkt<b/>, <b>mengeAufLager<b/>, <b>menge_auf_lager<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "IMAGE")
public class Image extends BaseEntity
{
    /** Свойство идентификатор изображения*/
    private Integer id_Image;
    /**Свойство заголовок*/
    private String title;
    /**Свойство дата загрузки*/
    private LocalDate uploadDate;
    /**Свойство расширение*/
    private String extension;
    /**Свойство размер*/
    private long size;

    public Image(Integer id_Image, String title, LocalDate uploadDate, String extension, Long size)
    {
        this.id_Image = id_Image;
        this.title = title;
        this.uploadDate = uploadDate;
        this.extension = extension;
        this.size = size;
    }
    public Image(){}

    @Id
    @GeneratedValue(generator = "SQLImage", strategy = GenerationType.AUTO)
    @Column(name = "ID_image", unique = true, nullable = false)
    public Integer getId_Image() { return id_Image; }
    public void setId_Image(Integer id_Image) { this.id_Image = id_Image; }

    @NonNull
    @Column(name = "Title")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @NonNull
    @Column(name = "Upload_date", updatable = false, nullable = false)
    public LocalDate getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDate uploadDate) { this.uploadDate = uploadDate; }

    @NonNull
    @Column(name = "Extension")
    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }

    @NonNull
    @Column(name = "Size")
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
}
