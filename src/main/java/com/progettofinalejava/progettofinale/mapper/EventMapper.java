package com.progettofinalejava.progettofinale.mapper;

import com.progettofinalejava.progettofinale.dto.EventDTO;
import com.progettofinalejava.progettofinale.entity.Event;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO(Event event);
    Event toEntity(EventDTO eventDTO);
}
