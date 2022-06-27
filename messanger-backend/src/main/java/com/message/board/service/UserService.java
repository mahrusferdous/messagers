package com.message.board.service;

import com.message.board.entity.User;
import com.message.board.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(User user) {
        if (!getUserByEmail(user.getEmail())) {
            userRepository.save(user);
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).get();
    }

    public boolean getUserByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
