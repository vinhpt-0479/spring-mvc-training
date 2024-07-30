package com.example.sprintbootdemo.controller.view;

import com.example.sprintbootdemo.model.User;
import com.example.sprintbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test/thymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf !");
        return "index";
    }

    @RequestMapping("/test/users")
    public String testUsers(Model model) {
        User[] users = userService.getAllUsers().toArray(new User[0]);
        model.addAttribute("users", users);
        return "users";
    }
}
