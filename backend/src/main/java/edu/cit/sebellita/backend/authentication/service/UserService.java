package edu.cit.sebellita.backend.authentication.service;

import edu.cit.sebellita.backend.authentication.entity.User;
import edu.cit.sebellita.backend.authentication.repository.UserRepository;
import edu.cit.sebellita.backend.authentication.dto.UserRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRegisterRequest user){
        if(userRepository.existsByEmail(user.getEmail())){ //can also be userRepository.existByLastnameOrFirstnameSortByAsc(user.getLastname(),user.getFirstname()) with appropriate methods in UserRepository
            throw new IllegalArgumentException("User already exists.");
        }

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setFullname(user.getFullname());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setStatus(user.getStatus());

        return userRepository.save(newUser);
    }

}
