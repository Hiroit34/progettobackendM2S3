package com.progettofinalejava.progettofinale.repository;

import com.progettofinalejava.progettofinale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
