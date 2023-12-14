package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.Message;


public interface MessageRepository extends JpaRepository<Message, Integer> {
}
