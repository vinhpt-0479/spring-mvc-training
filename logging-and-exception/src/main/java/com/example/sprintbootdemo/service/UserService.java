package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.exception.UserNotFoundException;
import com.example.sprintbootdemo.model.User;
import com.example.sprintbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        return user;
    }

    public User createUser(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new UserNotFoundException("User email should not be empty");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new UserNotFoundException("User name should not be empty");
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
