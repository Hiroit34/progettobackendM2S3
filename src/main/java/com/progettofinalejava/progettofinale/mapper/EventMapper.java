package com.progettofinalejava.progettofinale.mapper;

import com.progettofinalejava.progettofinale.entity.Event;
import com.example.demo.dto.EventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO(Event event);
    Event toEntity(EventDTO eventDTO);
}
