package com.facimath.facimath.repository;

import com.facimath.facimath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "Select u From User u Where u.login = :login and u.password = :password")
    Optional<User> findByLoginAndPassword(String login, String password);
}
