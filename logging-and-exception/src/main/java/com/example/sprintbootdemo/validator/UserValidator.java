package com.example.sprintbootdemo.validator;

import com.example.sprintbootdemo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Validate name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required.");

        // Validate email
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");
        if (user.getEmail() != null && !user.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            errors.rejectValue("email", "invalid.email", "Email should be valid.");
        }
    }
}
