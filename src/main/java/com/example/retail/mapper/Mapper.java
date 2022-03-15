package com.example.retail.mapper;

import com.example.retail.model.dto.BaseDTO;
import com.example.retail.model.entity.BaseEntity;

import java.util.List;
import java.util.function.Function;

public interface Mapper<E extends BaseEntity, D extends BaseDTO>
{
    E toEntity(D dto);
    D toDTO(E entity);

    List<D> listToDTO(List<E> list);
}
