package com.example.sprintbootdemo.controller.view;

import com.example.sprintbootdemo.service.UserService;
import org.springframework.ui.Model;
import com.example.sprintbootdemo.model.User;
import com.example.sprintbootdemo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserViewController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping("/createUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, BindingResult result, Model model) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "createUser"; // Return to the form view if there are validation errors
        }

        userService.createUser(user);

        return "redirect:/users/success";
    }

    @GetMapping("/users/success")
    public String success(Model model) {
        model.addAttribute("message", "User created successfully!");
        return "success";
    }
}
