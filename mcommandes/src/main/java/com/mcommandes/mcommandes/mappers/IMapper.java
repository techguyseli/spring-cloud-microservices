package com.mcommandes.mcommandes.mappers;

public interface IMapper<T, DTO> {

    T dtoToObject(DTO dto);
    DTO objectToDto(T object);
    
}
