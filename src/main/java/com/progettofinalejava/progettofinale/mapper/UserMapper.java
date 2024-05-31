package com.progettofinalejava.progettofinale.mapper;

import com.progettofinalejava.progettofinale.dto.UserDTO;
import com.progettofinalejava.progettofinale.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "roles", target = "roles")
    })
    UserDTO toDTO(User user);

    @Mappings({
            @Mapping(source = "roles", target = "roles")
    })
    User toEntity(UserDTO userDTO);
}
