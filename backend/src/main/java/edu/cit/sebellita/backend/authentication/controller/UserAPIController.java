package edu.cit.sebellita.backend.authentication.controller;

import edu.cit.sebellita.backend.authentication.entity.User;
import edu.cit.sebellita.backend.authentication.dto.UserRegisterRequest;
import edu.cit.sebellita.backend.authentication.dto.UserRegisterResponse;
import edu.cit.sebellita.backend.authentication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> postUsers(@RequestBody UserRegisterRequest request){
        
        User user = userService.createUser(request);
        UserRegisterResponse response = new UserRegisterResponse();
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());

        return ResponseEntity.ok(response);
    }
}
