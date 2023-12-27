package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String username;
}
