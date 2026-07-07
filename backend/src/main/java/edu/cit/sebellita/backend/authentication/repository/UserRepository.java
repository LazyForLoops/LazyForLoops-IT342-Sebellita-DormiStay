package edu.cit.sebellita.backend.authentication.repository;

import edu.cit.sebellita.backend.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findByFullname(String fullname);

}