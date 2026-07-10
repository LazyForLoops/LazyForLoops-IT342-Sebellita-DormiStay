package edu.cit.sebellita.backend.user.controller;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.cit.sebellita.backend.user.entity.User;
import edu.cit.sebellita.backend.user.entity.UserRole;
import edu.cit.sebellita.backend.user.entity.UserStatus;
import edu.cit.sebellita.backend.user.repository.UserRepository;
import edu.cit.sebellita.backend.user.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserAPIControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void loginShouldReturnUserWhenCredentialsMatch() {
        User user = new User();
        user.setId(1L);
        user.setEmail("student@example.com");
        user.setFullname("Student User");
        user.setPassword("secret123");
        user.setRole(UserRole.RESIDENT);
        user.setStatus(UserStatus.ACTIVE);

        when(userRepository.findByEmail("student@example.com")).thenReturn(Optional.of(user));

        Optional<User> result = userService.loginUser("student@example.com", "secret123");

        assertTrue(result.isPresent());
        assertEquals("student@example.com", result.get().getEmail());
    }
}
