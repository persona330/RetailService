package com.example.retail.mapper;

import com.example.retail.model.dto.AreaDTO;
import com.example.retail.model.dto.OrderDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.entity.Area;
import com.example.retail.model.entity.Order;
import com.example.retail.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StorageConditionsMapper.class, StoreMapper.class})
public interface AreaMapper
{
    @Mappings({
            @Mapping(target = "storageConditions", source = "storageConditionsDTO"),
            @Mapping(target = "store", source = "storeDTO")
    })
    Area toEntity(AreaDTO dto);
    @Mappings({
            @Mapping(target = "storageConditionsDTO", source = "storageConditions"),
            @Mapping(target = "storeDTO", source = "store")
    })
    AreaDTO toDTO(Area entity);
    List<AreaDTO> listToDTO(List<Area> entityList);
}
