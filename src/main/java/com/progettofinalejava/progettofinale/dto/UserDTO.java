package com.progettofinalejava.progettofinale.dto;

import com.progettofinalejava.progettofinale.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserDTO {

    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 10, message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max=15, message = "Password must be between 8 and 15 characters")
    private String password;

    private Set<Role> roles;
}
