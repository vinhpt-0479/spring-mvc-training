package nmt.controller;

import nmt.model.User;
import nmt.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserValidator userValidator;

    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "userForm";
        }

        model.addAttribute("message", "User submitted successfully!");
        return "userResult";
    }
}
