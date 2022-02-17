package com.example.demo.model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/users/{id}-{password}")
    public void changePassword(@PathVariable Long id, @PathVariable String password) {repository.getById(id).setPassword(password);}

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{id}")
    public boolean validateUser(@PathVariable Long id) {
        return repository.existsById(id);
    }
}
