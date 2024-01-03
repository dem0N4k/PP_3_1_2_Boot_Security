package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.AdminService;

import java.util.List;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        List<User> allUsers = adminService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }


    @GetMapping("admin/saveUser")
    public String saveUserForm(User user) {
        return "user-create";
    }


    @PostMapping("admin/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        adminService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam("id") Long id, Model model) {
        User user = adminService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        adminService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        adminService.deleteUser(id);
        return "redirect:/";
    }
}