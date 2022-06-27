package com.message.board.controller;

import com.message.board.entity.User;
import com.message.board.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    private List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    private User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/user", params = {"email", "password"})
    private User getUserByEmail(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

}
