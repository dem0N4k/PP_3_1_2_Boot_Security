package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    User getUser(Long id);

    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUser(Long id);

    Optional<User> findByUsername(String username);


}
