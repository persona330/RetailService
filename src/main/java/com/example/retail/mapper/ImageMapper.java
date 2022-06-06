package com.example.retail.mapper;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ImageDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper
{
    Image toEntity(ImageDTO dto);
    ImageDTO toDTO(Image entity);
    List<ImageDTO> listToDTO(List<Image> entityList);
}
