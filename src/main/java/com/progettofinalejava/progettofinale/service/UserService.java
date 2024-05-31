package com.progettofinalejava.progettofinale.service;

import com.progettofinalejava.progettofinale.dto.UserDTO;
import com.progettofinalejava.progettofinale.entity.User;
import com.progettofinalejava.progettofinale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDTO userDTO) {
        // Creazione diretta dell'istanza User utilizzando i dati del DTO

        System.out.println("Received userDTO: " + userDTO);
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        System.out.println("Saving user with username: " + user.getUsername());
        System.out.println("Saving user with password: " + user.getPassword());

        // Salva l'utente nel repository
        user = userRepository.save(user);

        // Converti l'utente salvato in DTO e restituiscilo
        UserDTO savedUserDTO = new UserDTO();
        savedUserDTO.setUsername(user.getUsername());
        savedUserDTO.setPassword(null); // Non restituire la password



        return savedUserDTO;
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Converti l'utente trovato in DTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(null); // Non restituire la password

        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUsername(user.getUsername());
                    userDTO.setPassword(null); // Non restituire la password
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = user.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
