package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }


    @GetMapping("/saveUser")
    public String saveUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }



    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}