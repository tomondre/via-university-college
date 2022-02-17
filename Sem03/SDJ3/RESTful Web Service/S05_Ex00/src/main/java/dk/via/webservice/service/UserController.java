package dk.via.webservice.service;

import dk.via.webservice.dao.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<User> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    public User createUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/employees/{id}")
    public boolean validateUser(@PathVariable Long id) {
        return repository.existsById(id);
    }

    @PutMapping("/employees/{id}-{password}")
    public void changePassword(@PathVariable Long id, @PathVariable String password) {
        try {
            repository.getById(id).setPassword(password);
        } catch (Exception ignored) {
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
