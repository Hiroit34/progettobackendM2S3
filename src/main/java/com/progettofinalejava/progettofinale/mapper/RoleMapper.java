package com.progettofinalejava.progettofinale.mapper;

import com.progettofinalejava.progettofinale.dto.RoleDTO;
import com.progettofinalejava.progettofinale.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDto(Role role);
    Role toRole(RoleDTO roleDTO);
}
