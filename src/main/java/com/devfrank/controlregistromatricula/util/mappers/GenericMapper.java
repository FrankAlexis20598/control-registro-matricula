package com.devfrank.controlregistromatricula.util.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<E, D, ID> {

    E toEntity(D dto);

    E toEntity(D dto, ID id);

    D toDto(E entity);

    default List<E> toEntityList(List<D> dtos) {
        return dtos == null ? null : dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<D> toDtoList(List<E> entities) {
        return entities == null ? null : entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
