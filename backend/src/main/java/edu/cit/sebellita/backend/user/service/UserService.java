package edu.cit.sebellita.backend.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cit.sebellita.backend.user.dto.UserAuthRequest;
import edu.cit.sebellita.backend.user.entity.User;
import edu.cit.sebellita.backend.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserAuthRequest user){
        if(userRepository.existsByEmail(user.getEmail())){ //can also be userRepository.existByLastnameOrFirstnameSortByAsc(user.getLastname(),user.getFirstname()) with appropriate methods in UserRepository
            throw new IllegalArgumentException("User already exists.");
        }

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setMiddlename(user.getMiddlename());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setStatus(user.getStatus());

        return userRepository.save(newUser);
    }

    public Optional<User> loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> password != null && password.equals(user.getPassword()));
    }

}
