package edu.unimagdalena.pw.myapi.api.dto;

import edu.unimagdalena.pw.myapi.entidades.User;
import edu.unimagdalena.pw.myapi.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
