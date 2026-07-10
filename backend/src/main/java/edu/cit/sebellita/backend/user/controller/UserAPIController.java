package edu.cit.sebellita.backend.user.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cit.sebellita.backend.user.dto.UserRegisterRequest;
import edu.cit.sebellita.backend.user.dto.UserRegisterResponse;
import edu.cit.sebellita.backend.user.entity.User;
import edu.cit.sebellita.backend.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserAPIController {

    private final UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok("All Users returned");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return ResponseEntity.ok("User Record sent");
    }

    @PostMapping
    public ResponseEntity<?> postUsers(@RequestBody UserRegisterRequest request) {
        try {
            User user = userService.createUser(request);
            UserRegisterResponse response = new UserRegisterResponse();
            response.setEmail(user.getEmail());
            response.setFullname(user.getFullname());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Registration failed."));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRegisterRequest request) {
        if (request == null || request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Email and password are required."));
        }

        Optional<User> foundUser = userService.loginUser(request.getEmail(), request.getPassword());
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            UserRegisterResponse response = new UserRegisterResponse();
            response.setEmail(user.getEmail());
            response.setFullname(user.getFullname());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid email or password."));
    }
}
