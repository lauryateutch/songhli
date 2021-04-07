package com.isj.si.GestionClientBackend.mappers;


import com.isj.si.GestionClientBackend.dto.ClientCreateDto;
import com.isj.si.GestionClientBackend.dto.ClientDto;
import com.isj.si.GestionClientBackend.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface ClientMapper {
    @Mapping(target="id",ignore=true)
    public Client toEntity (ClientCreateDto clientCreateDto);

    @Mapping(target="id",source="client.id")
    public ClientDto toDto (Client client);
}
