package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public String show(Principal principal) {
//        return "user";
//    }


//    @GetMapping(value = "/user")
//    public String getUserPage(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        return "userPage";
//    }



//    @GetMapping(value = "/user")
//    public String getUserPage2(Model modelMap, Principal principal) {
//        modelMap.addAttribute("user", userService.loadUserByUsername(principal.getUsername()));
//        return "user";
//    }
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "user";
//    }
}
