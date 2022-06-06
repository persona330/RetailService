package com.example.retail.repository;

import com.example.retail.model.entity.Group;
import com.example.retail.model.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends BaseRepository <Image, Integer>
{
    List<Image> findAll();
    Image getById(Integer id);
    void delete(Image group);
    Image getOne(Integer id);
    Image findByTitle(String title);
}
