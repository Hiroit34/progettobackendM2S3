package com.progettofinalejava.progettofinale.mapper;

import com.progettofinalejava.progettofinale.dto.UserDTO;
import com.progettofinalejava.progettofinale.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
