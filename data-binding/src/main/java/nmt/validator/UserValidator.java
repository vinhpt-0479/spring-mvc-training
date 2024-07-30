package nmt.validator;

import nmt.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errors.rejectValue("name", "field.required", "Name is required");
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "field.required", "Email is required");
        } else if (!user.getEmail().contains("@")) {
            errors.rejectValue("email", "field.invalid", "Email should be valid");
        }
    }
}
