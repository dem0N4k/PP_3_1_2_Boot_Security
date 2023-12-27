package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "surname")
    private String surName;
    private String password;
//    private User user;

    public User() {
    }

    public User(String username, String surName) {
        this.username = username;
        this.surName = surName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

//    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

//    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public User getUser() {
//        return this.user;
//    }

    @Override
    public String toString() {
        return "User " + id + ": " + username + " " + surName + " " + password;
    }
}
